package com.bc.spring.aop.xml;

import org.springframework.stereotype.Component;

//验证功能的切面
//对计算器输入参数进行验证
@Component
public class ValidateAspect{
        public void beforeMethod(){
                System.out.println("ValidateAspect->前置通知");
        }
 }
