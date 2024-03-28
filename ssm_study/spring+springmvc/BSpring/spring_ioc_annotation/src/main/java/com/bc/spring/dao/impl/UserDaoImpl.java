package com.bc.spring.dao.impl;

import com.bc.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("dao:saveUser");
    }
}
