package com.bc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SqlController {
    @Autowired
    private  JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/count")
    public String queryFormDruid(){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from emp", int.class);
        return integer.toString();
    }
}
