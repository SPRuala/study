package com.example.hikaricp.service.impl;

import com.example.hikaricp.mapper.UserMapper;
import com.example.hikaricp.pojo.User;
import com.example.hikaricp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
