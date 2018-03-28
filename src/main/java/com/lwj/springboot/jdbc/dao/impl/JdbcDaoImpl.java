package com.lwj.springboot.jdbc.dao.impl;

import com.lwj.springboot.jdbc.dao.JdbcDao;
import com.lwj.springboot.jdbc.entity.Jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        return jdbcTemplate.update("INSERT  INTO  jdbc (name,date) VALUES (" + jdbc.getName() + "," + jdbc.getDate() + ")");
    }

    @Override
    public int update(Jdbc jdbc) {
        return jdbcTemplate.update("UPDATE jdbc SET name=" + jdbc.getName() + ",date=" + jdbc.getDate() + "where id =" + jdbc.getId());
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
