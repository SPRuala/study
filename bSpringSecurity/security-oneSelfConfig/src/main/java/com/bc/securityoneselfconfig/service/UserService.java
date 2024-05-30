package com.bc.securityoneselfconfig.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bc.securityoneselfconfig.entity.User;

public interface UserService extends IService<User> {


    void saveUserDetails(User user);
}
