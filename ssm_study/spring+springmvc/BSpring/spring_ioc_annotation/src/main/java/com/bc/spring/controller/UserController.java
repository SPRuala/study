package com.bc.spring.controller;

import com.bc.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//为此类配置的bean设置的自定义id
@Controller("controllerId")
public class UserController {
    @Autowired
    private UserService userService;

    /*public UserController(UserService userService) {
        this.userService = userService;
    }*/


   /* public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    public void saveUser(){
        userService.saveUser();
    }
}
