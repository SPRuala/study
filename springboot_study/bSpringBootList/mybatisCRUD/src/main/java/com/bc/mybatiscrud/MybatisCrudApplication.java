package com.bc.mybatiscrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.bc.mybatiscrud.mapper.UserMapper")
public class MybatisCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisCrudApplication.class, args);
    }

}
