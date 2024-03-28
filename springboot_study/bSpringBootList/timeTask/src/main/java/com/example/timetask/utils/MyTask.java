package com.example.timetask.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;


@Configuration      //标记为配置类,使Spring Boot容器可以扫描到;或使用@Component
@EnableScheduling   //开启定时任务
public class MyTask {
    //实现业务:
    //在此注入service
    //任务方法中调用service

    //添加定时任务,定时发布公告
    @Scheduled(cron = "*/5 * * * * ?")      //@Scheduled: 日常任务
    public void publishMassage(){
        //LocalDateTime.now(): 获取当前时间
        System.out.println("睡眠中:"+ LocalDateTime.now());
    }
}
