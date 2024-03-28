package com.example.hikaricp.controller;

import com.example.hikaricp.bo.UserBO;
import com.example.hikaricp.pojo.User;
import com.example.hikaricp.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll(){
        List<User> userList = userService.getAll();
        userList.forEach(System.out::println);
        return userList;
    }
    @GetMapping("/insertUser")
    public void insertUser(){
        User user=new User(6,"three",33);
        userService.insertUser(user);
    }
    @PostMapping("/insertUserBo")
    public void insertUserBo(@RequestBody UserBO userBO){
        //id由后端生成
        int id= (int) (Math.random()*100);
        //实例化数据层对象
        User user = new User();
        BeanUtils.copyProperties(userBO, user);//将一个对象拷贝到另一个对象(要求两个对象属性一致);当前bo只接了name和age,故不会拷贝id
        user.setId(id);//单另设置id
        userService.insertUser(user);

    }
}
