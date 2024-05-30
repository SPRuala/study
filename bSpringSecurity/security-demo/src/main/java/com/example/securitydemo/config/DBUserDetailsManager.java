package com.example.securitydemo.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.securitydemo.entity.User;
import com.example.securitydemo.mapper.UserMapper;
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


@Component
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {
    @Resource
    private UserMapper userMapper;
    @Override
    public void createUser(UserDetails user) {

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
//        if (user!=null){ //如果user不是空值
//            //创建一个权限列表(类型为Collection)authorities
//            //fixme: 暂时为空
//            Collection<GrantedAuthority> authorities = new ArrayList<>(); //Collection为接口,无法实例化,则实例化具体的列表
//            return new org.springframework.security.core.userdetails.User(
//                    user.getUsername(),
//                    user.getPassword(),
//                    user.getEnabled(),
//                    true, //用户账号是否未过期
//                    true, //用户凭证是否未过期
//                    true, //用户是否为被锁定(设置为 是 )
//                    authorities// 权限列表
//            );
//        }else {
//            throw new UsernameNotFoundException(username);
//        }
    }


    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }
}
