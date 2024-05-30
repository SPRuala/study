package com.bc.securityoneselfconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    //不做自定义配置时,spring security默认实现以下代码中的功能
    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {

        http //针对httpSecurity对象进行一系列配置,并生成过滤器链
                .authorizeRequests(
                        authorize -> authorize //authorizeRequests():开启授权保护
                                .anyRequest() //对所有请求开启授权保护
                                .authenticated() //对已认证的请求自动被授权
                )
                .formLogin(form ->{
                    form.loginPage("/login").permitAll() //取消对该路径的授权保护
                            .usernameParameter("myusername") //重新定义后端接收name参数的名字,默认值为username
                            .passwordParameter("mypassword") //重新定义后端接收password参数的名字,默认值为password
                            .failureUrl("/login?fail"); //校验失败时跳转的地址,默认为 error
                }) //表单授权方式(登录表单页流程+登出页流程)
                .httpBasic(withDefaults());//基本授权方式(最原始,无登录登出页)(先经过.formLogin(withDefaults()方法,则在开启表单授权情况下再开启基本授权时,基本授权无效)

        //关闭csrf攻击防御机制
//        http.csrf(csrf -> csrf.disable());

        return http.build(); //创建httpSecurity对象 生成过滤器链
    }
}
