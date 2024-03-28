package com.bc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    //@RequestMapping请求映射:把浏览器发送的请求映射到该方法的执行
    //"/"绝对路径:由服务器解析为localhost:8080/+上下文路径
    //请求路径和@RequestMapping所设置的value值一样,此时此方法处理请求
    @RequestMapping("/")
    public String protal(){
        //将逻辑视图返回
        //逻辑视图被视图解析器解析
        return "index";
    }
    //处理hello超链接们
    @RequestMapping("/hello")
    public String helloPage(){
        return "hello";
    }
}
