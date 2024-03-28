package com.bc.spring.test;

import com.bc.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopByAnnotationTest {
    @Test
    public void testAopByAnnotation(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("aop-annotation.xml");
        //aop底层使用代理模式
        //aop创建代理对象后,目标对象只能通过代理对象访问,不能直接访问
        //aop自动生成代理类 不知道代理类名 向上转型到接口类
        Calculator calculator=ioc.getBean(Calculator.class);
        calculator.add(1, 1);
        calculator.sub(1, 2);
        calculator.div(10, 2);
    }

}
