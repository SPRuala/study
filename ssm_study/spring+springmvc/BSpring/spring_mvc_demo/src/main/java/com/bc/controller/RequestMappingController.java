package com.bc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")//要想匹配到/hello应先匹配到/test
public class RequestMappingController {

    //请求路径为/test/hello和/test/abc
    //{ , }:处理一个请求多个请求路径
    //使用注解时只有value属性值，value可忽略不写
    //RequestMethod.GET:RequestMethod为枚举类型,直接使用.调用枚举项
    @RequestMapping(value = {"/hello","/abc"},
            method = {RequestMethod.POST,RequestMethod.GET},
            params = {"username","age=20","!passwd","gender!=女"},
            headers={"referer"}
    )
    public String hello(){
        return "hello";
    }
    @RequestMapping("/**/mode/ant")
    public String testAnt(){
        return "hello";
    }
    //@PathVariable:将路径中的id值赋值给参数Integer id
    //赋值参数时按顺序赋值
    @RequestMapping("/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id,@PathVariable("username")String username){
        System.out.println("id="+id);
        System.out.println("username="+username);
        return "hello";
    }
}
