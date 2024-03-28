package com.bc.mybatiscrud.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceTimeAspect {
    //公共切入点表达式(所有类型的 impl所有包下的(..表示包含其子包)类的 所有方法的所有参数列表)
    @Pointcut("execution(* com.bc.mybatiscrud.service.impl..*(..))")
    public void printCut(){}

    @Around("printCut()")
    public Object aroundAspectForServiceTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Class<?> aClass = proceedingJoinPoint.getTarget().getClass();
        String name = proceedingJoinPoint.getSignature().getName();
        System.out.println("正在执行::"+aClass+name);
        long startTime=System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();//方法执行,返回result结果
        long endTime=System.currentTimeMillis();
        long serviceTime=endTime-startTime;
        if (serviceTime>300){
            System.out.println("方法耗时:"+serviceTime+"执行过慢");
        }else if (serviceTime>2000){
            System.out.println("方法耗时:"+serviceTime+"执行略慢");
        }else {
            System.out.println("方法耗时:"+serviceTime);
        }
        return result;
    }
}
