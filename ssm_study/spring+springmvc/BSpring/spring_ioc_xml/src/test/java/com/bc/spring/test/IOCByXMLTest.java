package com.bc.spring.test;

import com.bc.spring.pojo.Person;
import com.bc.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    //获取bean的三种方式
    //1.根据bean的id
    //2.根据bean的类型
    //3.根据bean的id和类型
    @Test
    public void testIOCgetBeanById(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据bean的id
        Student studentOne= (Student) ioc.getBean("studentOne");
        System.out.println(studentOne);

    }
    @Test
    public void testIOCgetBeanByClass(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据bean的类型 （不需要强转 根据类型获取直接获取到该类型的对象）
        //根据类型获取时：要求ioc容器中有且只有一个类型匹配的bean
        Student student=ioc.getBean(Student.class);
        System.out.println(student);
    }
    @Test
    public void testIOCgetBeanByIdAndClass(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据bean的id和类型
        Student student=ioc.getBean("studentOne", Student.class);
        System.out.println(student);
    }
    //能否通过接口类型获取当前bean
    @Test
    public void testIOCgetBeanByImplements(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
      /*  //方法一 student对象获取了bean后通过向上转型赋值给了接口对象 √
       Person student=ioc.getBean(Student.class);*/

        //方法二 通过接口类型在ioc中匹配bean进行获取 √ （根据类型获取 类型只要兼容就可以获取到）
        //可以通过继承的父类和实现的接口来获取   （常用：根据类型的接口匹配某个bean）
       Person person=ioc.getBean(Person.class);
        System.out.println(person);
    }
}
