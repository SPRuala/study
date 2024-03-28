package com.bc.spring.impl;

import com.bc.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
