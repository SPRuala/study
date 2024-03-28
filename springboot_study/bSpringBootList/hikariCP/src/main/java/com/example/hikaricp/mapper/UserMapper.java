package com.example.hikaricp.mapper;

import com.example.hikaricp.pojo.User;
import com.example.hikaricp.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends MyMapper<User> {
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
