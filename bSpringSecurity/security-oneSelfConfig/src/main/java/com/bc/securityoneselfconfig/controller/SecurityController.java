package com.bc.securityoneselfconfig.controller;

import com.bc.securityoneselfconfig.entity.User;
import com.bc.securityoneselfconfig.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SecurityController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/list")
    public List<User> getList(){
        return userService.list();
    }
    @PostMapping("/add")
    public void add(@RequestBody User user){
        userService.saveUserDetails(user); //要对saveUser做特别的实现,故不能使用mybatisplus提供的save()方法添加用户
    }
}
