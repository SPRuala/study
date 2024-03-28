package com.example.dependencyinjection_invertscontrol.controller;

import com.example.dependencyinjection_invertscontrol.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController:是一个组合注解,包含了@Controller和@ResponseBody注解的功能
@RestController
public class StuController {


    @Autowired
    private Stu stu;


    @GetMapping("getStu")
    public Stu getStu(){
        //将Stu放入容器后,不用先new Stu再进行return,可以直接返回带参的Stu对象
        return stu;
    }
}
