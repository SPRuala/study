package com.bc.springboot.controller;

import com.bc.springboot.config.RabbitMQConsumer;
import com.bc.springboot.service.impl.CaganerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaganerController {
    @Autowired
    private RabbitMQConsumer rabbitMQConsumer;
    @Autowired
    private CaganerServiceImpl caganerService;
    //用户从MQ拿出一坨屎(开启拿屎用户)
    @GetMapping("/open")
    public String openPopConsumer(){
        caganerService.openPopConsumer("popConsumer");
        return "开启消费者成功";
    }
    //用户从MQ拿出一坨屎(关闭拿屎用户)
    @GetMapping("/close")
    public String closePopConsumer(){
        caganerService.closePopConsumer("popConsumer");
        return "关闭消费者成功";
    }
}
