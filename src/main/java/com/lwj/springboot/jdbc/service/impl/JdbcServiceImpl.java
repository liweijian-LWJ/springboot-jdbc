package com.lwj.springboot.jdbc.service.impl;

import com.lwj.springboot.jdbc.dao.JdbcDao;
import com.lwj.springboot.jdbc.entity.Jdbc;
import com.lwj.springboot.jdbc.service.JdbcService;
import com.lwj.springboot.jdbc.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "jdbcServiceImpl")
public class JdbcServiceImpl implements JdbcService {
    @Resource
    private JdbcDao jdbcDaoImpl;

    @Override
    public List<Jdbc> select() {
        return jdbcDaoImpl.select();
    }

    @Override
    public Result insert(Jdbc jdbc) {
        Result result = new Result();
        int insert = jdbcDaoImpl.insert(jdbc);
        if (insert < 0) {
            result.setMsg(Result.NO);
        } else {
            result.setMsg(Result.YES);
            result.setSuccess(true);
        }
        return result;
    }

    @Override
    public Result update(Jdbc jdbc) {
        Result result = new Result();
        int update = jdbcDaoImpl.update(jdbc);
        if (update <= 0) {
            result.setMsg(Result.NO);
        } else {
            result.setMsg(Result.YES);
            result.setSuccess(true);
        }
        return result;
    }

    @Override
    public Result delete(Integer id) {
        Result result = new Result();
        int delete = jdbcDaoImpl.delete(id);
        if (delete <= 0) {
            result.setMsg(Result.NO);
        } else {
            result.setMsg(Result.YES);
            result.setSuccess(true);
        }
        return result;
    }

    @Override
    public Jdbc selectById(Integer id) {
        return jdbcDaoImpl.selectById(id);
    }
}
