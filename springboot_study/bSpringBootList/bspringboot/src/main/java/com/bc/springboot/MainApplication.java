package com.bc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //SpringApplication.run()方法返回的是ioc容器
        ConfigurableApplicationContext ioc = SpringApplication.run(MainApplication.class, args);

        //查看容器内部组件名字
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();

        for (String beanName:beanDefinitionNames) {
            System.out.println("beanName = " + beanName);
        }
    }
}
