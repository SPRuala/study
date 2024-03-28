package com.bc.springboot.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    //用户从MQ拿出一坨屎
    @RabbitListener(id = "popConsumer",autoStartup = "false",queues = {RabbitMQConfig.QUEUE_CAGANER})
    public void getPop(String payload, Message message) {
        //拿到消息属性中的routingKey
        String receivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
        if (receivedRoutingKey.equalsIgnoreCase("bc.pop.push")){
            //todo: 拿屎业务
            System.out.println("用户拿出:"+payload);
        }
    }
}
