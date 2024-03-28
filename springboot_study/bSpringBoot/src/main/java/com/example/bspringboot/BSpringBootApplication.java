package com.example.bspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//程序的主入口,本身为Spring的一个组件
//@SpringBootApplication:扫描当前类所在包中的所有文件/包,故建包时应建在该类所在包下
@SpringBootApplication
public class BSpringBootApplication {

    public static void main(String[] args) {
        //将springboot应用启动 通过反射加载此类的对象
        SpringApplication.run(BSpringBootApplication.class, args);
    }

}
