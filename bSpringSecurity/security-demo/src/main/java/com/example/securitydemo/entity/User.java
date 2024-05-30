package com.example.securitydemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User{
    @TableId(type = IdType.AUTO) //mybatisplus: id自增
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;

}
