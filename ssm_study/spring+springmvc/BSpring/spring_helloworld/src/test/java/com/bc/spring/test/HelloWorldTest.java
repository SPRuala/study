package com.bc.spring.test;

import com.bc.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void test(){
        //获取ioc容器
        //configLocation:配置路径
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取ioc容器中的bean对象
            //根据bean的name来获取（id） (根据id获取不知道类型 默认为obj 需强转  不强转只能使用obj类的方法)
       HelloWorld helloWorld= (HelloWorld) ioc.getBean("helloworld");
        helloWorld.sayHello();
    }
}
