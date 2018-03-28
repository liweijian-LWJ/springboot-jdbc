package com.lwj.springboot.jdbc.service;

import com.lwj.springboot.jdbc.entity.Jdbc;
import com.lwj.springboot.jdbc.util.Result;

import java.util.List;

public interface JdbcService {
    List<Jdbc> select();

    Result insert(Jdbc jdbc);

    Result update(Jdbc jdbc);

    Result delete(Integer id);

    Jdbc selectById(Integer id);
}
