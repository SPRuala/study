package com.bc.mybatiscrud;

import com.bc.mybatiscrud.pojo.User;
import com.bc.mybatiscrud.service.impl.UserServiceImpl;
import com.bc.mybatiscrud.utils.makeid.IDMaker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //当前类会被spring boot加载为测试类
class MybatisCrudApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testSelectUser(){
        User user=new User();
        user.setId(String.valueOf(IDMaker.onlyString(10)));
        user.setName("测试测试类");
        user.setAge(20);
        userService.saveUser(user);
    }

}
