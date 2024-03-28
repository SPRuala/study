package com.bc.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Date;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //bean生命周期初始化之前执行

        System.out.println("后置处理器的postProcessBeforeInitialization");
        System.out.println("在"+ new Date()+"创建");
        return bean;//返回额外操作之后的bean对象
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //bean生命周期初始化之后执行
        System.out.println("后置处理器的postProcessAfterInitialization");
        return bean;
    }
}
