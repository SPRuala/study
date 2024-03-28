package com.bc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//入口控制层
@Controller
public class ProtalController {
    @RequestMapping("/")
    public String protal(){
        return "index";
    }
}
