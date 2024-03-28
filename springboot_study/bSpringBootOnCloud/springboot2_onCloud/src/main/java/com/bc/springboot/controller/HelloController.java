package com.bc.springboot.controller;

import com.bc.springboot.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;
    //自动装配RabbitTemplate模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/port")
    public String lookPort(){
        return "port"+port;
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello bc~";
    }

    @GetMapping("/producer")
    public String producer(){
        //rabbitTemplate.convertAndSend(exchange,routingKey , obj):发送消息
        //exchange:交换机名称
        //routingKey: 路由规则(需和绑定时的路由规则相匹配),通过路由生产者将消息发送给指定交换机,交换机再让接听队列进行处理(不同规则可以让不同接听队列进行处理)
                    /*RabbitMQ的routingKey:
                    * bc.msg.*: *=一个占位符,可用于匹配;匹配到后队列自行判断,根据不同的判断做不同的业务处理
                    *   eg:
                    *       bc.msg.* 匹配 bc.msg.send
                    *       bc.msg.*.* 匹配 bc.msg.do.display
                    *       bc.msg.*.* 匹配 bc.msg.display.send
                    *       bc.msg.*.*.* 匹配 bc.msg.send.do.display
                    *
                    * bc.msg.#: #=多个占位符,可用于匹配;匹配到后队列自行判断,根据不同的判断做不同的业务处理
                    *   eg:
                    *       bc.msg.# 匹配 bc.msg.send
                    *       bc.msg.# 匹配 bc.msg.do.display
                    *       bc.msg.# 匹配 bc.msg.display.send
                    *       bc.msg.# 匹配 bc.msg.send.do.display
                    * */
        //obj: 发送对象(通常为json字符串)
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_SENDMESSAGE, "bc.msg.send", "发送了一条消息");
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_SENDMESSAGE, "bc.msg.delete", "删除了一条消息");
        return "producer ok";
    }
}
