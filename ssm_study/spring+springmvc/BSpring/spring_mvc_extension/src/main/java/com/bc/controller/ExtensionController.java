package com.bc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExtensionController {
    @RequestMapping("test/hello")
    public String testHello(){
        return "success";
    }
}
