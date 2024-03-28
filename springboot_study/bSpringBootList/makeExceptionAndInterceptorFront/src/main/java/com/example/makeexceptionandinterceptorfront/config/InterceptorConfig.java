package com.example.makeexceptionandinterceptorfront.config;

import com.example.makeexceptionandinterceptorfront.controller.interceptor.StudentInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    //将Interceptor放入容器
    @Bean
    public StudentInterceptor studentInterceptor(){
        return new StudentInterceptor();
    }

    //注解拦截器(需实现WebMvcConfigurer接口)
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(studentInterceptor())//注册已经放入容器的指定拦截器
                .addPathPatterns("/getStudent");//拦截的路径
    }
}
