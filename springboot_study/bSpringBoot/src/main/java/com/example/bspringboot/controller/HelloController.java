package com.example.bspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //请求映射可以看作一个接口  接口:http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){
        return "hello,World";
    }
}
