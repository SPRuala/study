package com.bc.springboot.utils;

import com.bc.springboot.service.impl.CaganerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TimeTask {
    @Autowired
    private CaganerServiceImpl caganerService;

    @Scheduled(cron = "*/5 * * * * ?")
    public void addPopToMQ(){
        try {
            //生成一坨屎
            String popName = caganerService.createPop();
            System.out.println(popName);
            //拉入MQ
            caganerService.pushPop(popName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" 拉屎失败 ");
        }

    }

}
