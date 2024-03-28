package com.bc.springboot.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    //创建监听队列
    //@RabbitListener(queues = 需要监听的队列,可以是多个)
    @RabbitListener(queues = {RabbitMQConfig.QUEUE_SENDMESSAGE})
    public void watchQueue(String payload, Message message){
        //payload: 消息的载体(消息内容)
        System.out.println(payload);
        //message:拿到生产者的消息;message.getMessageProperties().getReceivedRoutingKey():拿到消息属性中的routingKey
        String receivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
        System.out.println(receivedRoutingKey);
        //对拿到的routingKey进行判断: 业务场景中,监听者中会有不同的routingKey(eg: bc.msg.send、bc.msg.delete)
        if (receivedRoutingKey.equalsIgnoreCase("bc.msg.send")){
            //fixme : 处理发送类的业务
            System.out.println("这里处理长时间的发送类业务");
        }else if (receivedRoutingKey.equalsIgnoreCase("bc.msg.delete")){
            //fixme : 处理删除类的业务
            System.out.println("这里处理长时间的删除类业务");
        }
    }
}
