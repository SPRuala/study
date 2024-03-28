package com.bc.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {
    //前置通知 @Before(切入点表达式)
//    @Before("execution(public int com.bc.spring.aop.annotation.CalculatorImpl.add(int ,int ))")
    //前置通知作用于所有方法
        //*:任意访问修饰符、返回值类型、包下所有的类、类中的所有方法
        //():方法的参数列表
        //..:任意方法中的任意参数列表
    @Before("execution(* com.bc.spring.aop.annotation.CalculatorImpl.*(..))")
    //joinPoint:帮助获取连接点信息,切入点表达的是哪个方法JoinPoint就表达该方法的信息
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法的签名信息
        //signature.getName():获取连接点对应方法的方法名
        Signature signature=joinPoint.getSignature();
        //获取连接点对应方法的参数(内存地址)
        Object[] args= joinPoint.getArgs();
        System.out.println("LoggerAspect,前置通知,方法:"+signature.getName()+",参数:"+ Arrays.toString(args));

    }

    //后置通知
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
       Signature signature=joinPoint.getSignature();
        System.out.println("------------------LoggerAspect,后置通知,方法:"+signature.getName()+"执行完毕-------------------------");
    }
    //返回通知
    //returning:设置当前返回通知中 用来接收目标对象的返回值参数 的参数名   需在返回通知参数列表设置同名Obj类型参数(eg:result)
    @AfterReturning(value = "pointCut()",returning ="result" )
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature=joinPoint.getSignature();
        System.out.println("LoggerAspect,返回通知,方法:"+signature.getName()+"返回值:"+result);
    }
    //异常通知
    //throwing:设置当前异常通知中  用来接收异常  需在异常通知参数列表设置同名Exception/Throwable类型参数(eg:e)
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void  afterThrowingAdviceMethod(JoinPoint joinPoint,Exception e){
        Signature signature=joinPoint.getSignature();
        System.out.println("LoggerAspect,异常通知,方法:"+signature.getName()+",异常:"+e);
    }
    //环绕通知
    //类似于动态代理,手动给方法添加额外操作
    //环绕通知一定要将目标方法的返回值进行返回
    //需要在此通知中体现目标对象的执行
    //ProceedingJoinPoint:可执行的连接点对象
    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint proceedingJoinPoint){
        //设置返回值
        Object result = null;
        try {
            System.out.println("环绕通知->前置通知");
            //表示目标对象方法的执行
            result=proceedingJoinPoint.proceed();
            System.out.println("环绕通知->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知->异常通知");
        }finally {
            System.out.println("环绕通知->后置通知");
        }
        return result;
    }
    //切入点表达式的重用
    //声明一个公共的切入点表达式
    @Pointcut("execution(* com.bc.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}
}
