package com.bc.spring.test;

import com.bc.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopByXmlTest {
    @Test
    public void testAopByXml(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        int result = calculator.add(2, 4);
        System.out.println(result);
    }
}
