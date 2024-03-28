package com.bc.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootTest
public class BSpringBootSqlApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DruidDataSource dataSource;
    @Test
    public void sqlTest(){

        Integer integer = jdbcTemplate.queryForObject("select count(*) from emp", int.class);
        System.out.println("integer = " + integer);
        System.out.println("dataSource = " + dataSource.getClass());//配置了Druid数据源,jdbcTemplate也经过Druid数据源进行查询

    }
}
