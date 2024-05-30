package com.bc.securityoneselfconfig.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bc.securityoneselfconfig.entity.User;
import com.bc.securityoneselfconfig.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;


//对用户的一系列操作(CRUD、判断是否存在)都可以在此进行操作
//updateUser()、deleteUser()、changePassword()、userExists()、updatePassword()等都与createUser()写法类似,都使用userMapper对数据库进行CRUD
@Component
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {
    @Resource
    private UserMapper userMapper;


    /**
     * 向数据库中插入新的用户信息
     * @param userDetails
     */
    @Override
    public void createUser(UserDetails userDetails) {
        //在此向数据库中插入数据
        //创建user对象,并为其设置好来自于userDetails的属性值
        User user = new User();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEnabled(true);
        //使用userMapper进行数据插入
        userMapper.insert(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    /**
     * 从数据库中获取user对象
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>(); //mybatisplus查询对象
        userQueryWrapper.eq("username", username);//.eq创建查询条件,"username"为表中字段,username为传递参数
        User user = userMapper.selectOne(userQueryWrapper);//查询出一条数据

        if (user == null){
            throw new UsernameNotFoundException(username);
        }else {
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), //对应实体类中的username
                    user.getPassword(),
                    user.getEnabled(),
                    true,
                    true,
                    true,
                    authorities
            );
        }
    }


    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }
}
