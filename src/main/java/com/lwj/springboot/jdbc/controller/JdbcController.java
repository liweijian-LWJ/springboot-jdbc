package com.lwj.springboot.jdbc.controller;

import com.lwj.springboot.jdbc.entity.Jdbc;
import com.lwj.springboot.jdbc.service.JdbcService;
import com.lwj.springboot.jdbc.util.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/*
*@Author:liweijian
*/
@Controller
@RequestMapping(value = "/")
public class JdbcController {

    @Resource
    private JdbcService jdbcServiceImpl;

    @ApiOperation(value = "查询")
    @RequestMapping(value = "select", method = RequestMethod.GET)
    @ResponseBody
    public List<Jdbc> select() {
        return jdbcServiceImpl.select();
    }

    @ApiOperation(value = "新增")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@RequestBody Jdbc jdbc) {
        return jdbcServiceImpl.insert(jdbc);
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody Jdbc jdbc) {
        return jdbcServiceImpl.update(jdbc);
    }

    @ApiOperation(value = "删除单条")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam(required = true) Integer id) {
        return jdbcServiceImpl.delete(id);
    }

    @ApiOperation(value = "查询单条")
    @RequestMapping(value = "selectById", method = RequestMethod.POST)
    @ResponseBody
    public Jdbc selectById(@RequestParam(required = true) Integer id) {
        return jdbcServiceImpl.selectById(id);
    }
}
