package com.example.securitydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration //将该类标识为一个配置类
@EnableWebSecurity //在配置类中添加@EnableWebSecurity 注解, 开启Spring Security自定义配置
public class WebSecurityConfig {
/*    //创建一个UserDetailsService对象(UserDetailsService为一个接口)
    //定义完成后,默认的UserDetailsService对象会被替换为自定义的UserDetailsService对象,该对象中默认用户名、密码等也会替换为自定义的用户名、密码..
    @Bean
    public UserDetailsService userDetailsService(){
        //创建基于内存的用户信息管理器(InMemoryUserDetailsManager),通过该类将user对象存入内存
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        //实例化PasswordEncoder
        PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //使用manager管理userdetails对象
        manager.createUser(User //创建userdetails类型的User对象(用于管理用户名、用户密码、用户权限等内容)
                .withUsername("ruala") //.username("user"): 定义用户名
                .password(passwordEncoder.encode("ruala"))//.password("password"): 定义密码(先通过passwordEncoder的encode()加密后再设置)
                .roles("USER") //.roles("USER"): 角色为USER
                .build());     //.build(): 通过build方法最终获得一个userdetails对象
        return manager;
    }*/

//    withDefaultPasswordEncoder()不安全写法(可用在测试中):
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
//        manager.createUser(
//                User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build()
//        );
//        return manager;
//    }

    //基于数据库的用户认证Service
    public UserDetailsService userDetailsService(){
        //创建基于数据库的用户信息管理器(DBUserDetailsManager),通过该类将user对象存入内存
        DBUserDetailsManager manager=new DBUserDetailsManager();
        return manager;
    }
}
