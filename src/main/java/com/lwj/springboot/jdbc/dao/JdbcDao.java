package com.lwj.springboot.jdbc.dao;

import com.lwj.springboot.jdbc.entity.Jdbc;

import java.util.List;

public interface JdbcDao {

    List<Jdbc> select();

    int insert(Jdbc jdbc);

    int update(Jdbc jdbc);

    int delete(Integer id);

    Jdbc selectById(Integer id);
}
