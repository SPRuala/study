package com.bc.spring.service.impl;

import com.bc.spring.dao.UserDao;
import com.bc.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void saveUser(){
       userDao.saveUser();
    }
}
