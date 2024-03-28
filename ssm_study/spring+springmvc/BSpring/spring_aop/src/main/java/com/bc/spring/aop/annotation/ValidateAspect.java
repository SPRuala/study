package com.bc.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//验证功能的切面
//对计算器输入参数进行验证
//@Order:改变该切面优先级
@Component
@Aspect
@Order(1)
public class ValidateAspect{
        //单写切入点表达式
//        @Before("execution(* com.bc.spring.aop.annotation.CalculatorImpl.*(..))")
        //访问另一个切面的公共切入点表达式
        @Before("com.bc.spring.aop.annotation.LoggerAspect.pointCut()")
        public void beforeMethod(){
                System.out.println("ValidateAspect->前置通知");
        }
 }
