//package com.bc.springboot.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RefreshScope //@RefreshScope:配置刷新 一旦发现某配置产生变更,便会在controller控制器中刷新该值
//public class NacosController {
//    @Value("${alibaba.config.name}")
//    private String name;
//    @Value("${alibaba.config.limit}")
//    private String limit;
//    @GetMapping("/getConfig")
//    public String getConfig(){
//        return name+":"+limit;
//    }
//}
//
