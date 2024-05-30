package com.bc.securityoneselfconfig.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bc.securityoneselfconfig.config.DBUserDetailsManager;
import com.bc.securityoneselfconfig.entity.User;
import com.bc.securityoneselfconfig.mapper.UserMapper;
import com.bc.securityoneselfconfig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private DBUserDetailsManager dbUserDetailsManager; //需调用dbUserDetailsManager的createUser()方法,故将其自动装配到该类


    @Override
    public void saveUserDetails(User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //createUser()需要UserDetails对象
        //UserDetails为一个接口,则需要实例化具体的类型(参照security-demo模块中的WebSecurityConfig)
        //manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles("USER")
                .build();
        dbUserDetailsManager.createUser(userDetails);//把创建的userDetails用户对象传递给createUser()
    }
}
