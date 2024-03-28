package com.bc.getmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.annotation.MapperScan; //原生MapperScan
@SpringBootApplication
@MapperScan
public class GetMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetMybatisApplication.class, args);
    }

}
