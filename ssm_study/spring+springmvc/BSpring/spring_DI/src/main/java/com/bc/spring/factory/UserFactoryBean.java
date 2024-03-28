package com.bc.spring.factory;

import com.bc.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        //UserFactoryBean提供用户对象
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        //对象类型为User.class
        return User.class;
    }
}
