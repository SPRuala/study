package com.example.hikaricp.service;

import com.example.hikaricp.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * 查询所有
     * @return List<User>
     */
    List<User> getAll();

    /**
     * 添加
     * @param user
     */
    void insertUser(User user);
}
