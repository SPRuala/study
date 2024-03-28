package com.example.asynchronous.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDateTime;


@Configuration      //标记为配置类,使Spring Boot容器可以扫描到;或使用@Component
@EnableAsync   //开启异步任务
public class MyAsyncTask {
    //实现业务:
    //在此注入service
    //任务方法中调用service

    //添加异步任务
    @Async //@Async: 异步注解
    public void publishMassage(){
        try {
            Thread.sleep(5000);//睡眠五秒
            //LocalDateTime.now(): 获取当前时间
            System.out.println("异步任务处理完毕:"+ LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
