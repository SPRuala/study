package com.example.makeerrorpage.controller;

import com.example.makeerrorpage.pojo.Student;
import com.example.makeerrorpage.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class StudentController {

    @GetMapping("/getStudent")
    public JsonResult getStudent(Integer sid){
        Student student = new Student(1, "zsb", 11);
        System.out.println(sid);
        log.debug(student.toString());
        log.info(student.toString());
        log.warn(student.toString());
        log.error(student.toString());
//        return JsonResult.normalError("测试错误");
        return JsonResult.ok(student);
    }
    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Map<String,Object> map,
                              @RequestHeader("token") String token,
                              @CookieValue("cookieId") String cookieId){
        System.out.println("map = " + map);
        System.out.println("token = " + token);
        System.out.println("cookieId = " + cookieId);
    }

}
