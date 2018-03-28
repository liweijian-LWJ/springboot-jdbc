package com.lwj.springboot.jdbc.dao.impl;

import com.lwj.springboot.jdbc.dao.JdbcDao;
import com.lwj.springboot.jdbc.entity.Jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository(value = "jdbcDaoImpl")
public class JdbcDaoImpl implements JdbcDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Jdbc> select() {
        return jdbcTemplate.query("SELECT  * FROM  jdbc", new BeanPropertyRowMapper(Jdbc.class));
    }

    @Override
    public int insert(Jdbc jdbc) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jdbc.getDate());
        String sql = "INSERT  INTO  jdbc (name,date) VALUES (?,?)";
        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, jdbc.getName());
                preparedStatement.setDate(2, Date.valueOf(date));
                return preparedStatement;
            }
        });
    }

    @Override
    public int update(Jdbc jdbc) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jdbc.getDate());
        String sql = "UPDATE jdbc SET name=?, date=? where id = ?";
        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, jdbc.getName());
                Date date1 = new Date(jdbc.getDate().getTime());
                preparedStatement.setDate(2, Date.valueOf(date));
                preparedStatement.setInt(3, jdbc.getId());
                return preparedStatement;
            }
        });
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM  jdbc WHERE  id = " + id);
    }

    @Override
    public Jdbc selectById(Integer id) {
        return (Jdbc) jdbcTemplate.queryForObject("SELECT  * FROM  jdbc where id=" + id, new BeanPropertyRowMapper(Jdbc.class));
    }
}
