package com.bc.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {
    //前置通知
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,前置通知,方法:" + signature.getName() + ",参数:" + Arrays.toString(args));

    }

    //后置通知
    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("------------------LoggerAspect,后置通知,方法:" + signature.getName() + "执行完毕-------------------------");
    }

    //返回通知
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,返回通知,方法:" + signature.getName() + "返回值:" + result);
    }

    //异常通知
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,异常通知,方法:" + signature.getName() + ",异常:" + e);
    }

    //环绕通知
    //类似于动态代理,手动给方法添加额外操作
    //环绕通知一定要将目标方法的返回值进行返回
    //需要在此通知中体现目标对象的执行
    //ProceedingJoinPoint:可执行的连接点对象(切点)
    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint proceedingJoinPoint) {
        //设置返回值
        Object result = null;
        try {
            System.out.println("环绕通知->前置通知");
            //表示目标对象方法的执行
            result = proceedingJoinPoint.proceed();
            System.out.println("环绕通知->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知->异常通知");
        } finally {
            System.out.println("环绕通知->后置通知");
        }
        return result;
    }
}
