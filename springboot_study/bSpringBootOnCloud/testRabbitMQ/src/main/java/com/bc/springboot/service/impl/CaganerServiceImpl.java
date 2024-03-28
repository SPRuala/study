package com.bc.springboot.service.impl;

import com.bc.springboot.config.RabbitMQConfig;
import com.bc.springboot.service.CaganerService;
import com.bc.springboot.utils.IDMaker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class CaganerServiceImpl implements CaganerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;
    //生成一坨屎
    @Override
    public String createPop() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String popName = IDMaker.customizePrefix("💩便便", "onlyNum", 8);
        return popName;
    }

    //将屎拉入MQ
    @Override
    public void pushPop(String popName){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_CAGANER, "bc.pop.push", popName);
        System.out.println("已拉入");
    }
    //用户从MQ拿出一坨屎(虽然被我注释掉了,但是写在这也是可以的,只是起监听作用而已,把堆积在MQ的屎一次性拿完)
    /*@Override
    @RabbitListener(queues = {RabbitMQConfig.QUEUE_CAGANER})
    public String getPop(String payload, Message message) {
        //拿到消息属性中的routingKey
        String receivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
        if (receivedRoutingKey.equalsIgnoreCase("bc.pop.push")){
            //todo: 拿屎业务
            System.out.println("用户拿出:"+payload);
            return "已拿出"+payload;
        }
        return "无屎拿出,拿取失败";
    }*/

    //开启拿屎用户
    @Override
    public void openPopConsumer(String consumerID) {
        MessageListenerContainer consumerPop = rabbitListenerEndpointRegistry.getListenerContainer(consumerID);
        consumerPop.start();
    }
    //关闭拿屎用户
    @Override
    public void closePopConsumer(String consumerID) {
        MessageListenerContainer consumerPop=rabbitListenerEndpointRegistry.getListenerContainer(consumerID);
        consumerPop.stop();
    }
}
