package com.bc.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //配置类加上@Configuration,相当于在spring容器中,为类的成员添加@Bean注解使其存在于容器中
public class RabbitMQConfig {
    //定义交换机的名字
        //名字定义后不可以更改
        //变量名规范为大写
    public static final String EXCHANGE_SENDMESSAGE="exchange_sendMessage";
    //定义队列的名字
        //名字定义后不可以更改
        //变量名规范为大写
    public static final String QUEUE_SENDMESSAGE="queue_sendMessage";

    //创建交换机
    @Bean(EXCHANGE_SENDMESSAGE)//为Bean定义名字(交换机的名字为定义的变量EXCHANGE_SENDMESSAGE)(也可以写死为字符串)
    public Exchange exchange(){//最终返回的是交换机
        return ExchangeBuilder   //ExchangeBuilder: 构建交换机
                .topicExchange(EXCHANGE_SENDMESSAGE) //为该名字的交换机设定类型(topicExchange(通用型)、directExchange、fanoutExchange、headersExchange)
                .durable(true) //交换机持久化,服务器重启后(MQ必定也会重启),设置为false数据(交换机、队列)重启后会丢失,设置为true则不会
                .build(); //构建
    }

    //创建队列
    @Bean(QUEUE_SENDMESSAGE)//为Bean定义名字(交换机的名字为定义的变量EXCHANGE_SENDMESSAGE)(也可以写死为字符串)
    public Queue queue(){   //最终返回的是队列
        return new Queue(QUEUE_SENDMESSAGE); //返回new一个队列
    }

    //将队列绑定到交换机(如需绑定多个不同的队列和不同的交换机,需要构建多个)
        //@Qualifier: 引入容器中不同的bean对象
        //@Qualifier(Bean名字) 类型 形参名
    @Bean
    public Binding binding(@Qualifier(QUEUE_SENDMESSAGE) Queue queue,@Qualifier(EXCHANGE_SENDMESSAGE) Exchange exchange){
        //处理绑定关系
        return BindingBuilder //BindingBuilder绑定类
                .bind(queue)  //绑定队列
                .to(exchange) //绑定到哪个交换机(!不同类型的交换机有不同的构造函数)
                .with("bc.msg.*") //with(routingKey):路由规则,在此处只需广泛定义(便于具体规则匹配到),在创建生产者时具体定义
                .noargs(); //不需要任何参数内容
    }

}
