package com.bc.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    //定义交换机、队列名(拉屎)
    public static final String EXCHANGE_CAGANER="exchange_caganer";
    public static final String QUEUE_CAGANER="queue_caganer";
    //定义交换机、队列名(异步)
    public static final String EXCHANGE_ASYNC="exchange_async";
    public static final String QUEUE_ASYNC="queue_async";
    //创建交换机
    @Bean(EXCHANGE_CAGANER)
    public Exchange exchange(){
        return ExchangeBuilder
                .topicExchange(EXCHANGE_CAGANER)
                .durable(true)
                .build();
    }
    @Bean(EXCHANGE_ASYNC)
    public Exchange exchangeAsync(){
        return ExchangeBuilder
                .topicExchange(EXCHANGE_ASYNC)
                .durable(true)
                .build();
    }
    //创建队列
    @Bean(QUEUE_CAGANER)
    public Queue queue(){
        return new Queue(QUEUE_CAGANER);
    }
    @Bean(QUEUE_ASYNC)
    public Queue queueAsync(){
        return new Queue(QUEUE_ASYNC);
    }
    //队列绑定到交换机
    @Bean("bindingQueueToExchange")
    public Binding bindingQueueToExchange(@Qualifier(QUEUE_CAGANER) Queue queue,@Qualifier(EXCHANGE_CAGANER) Exchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("bc.pop.*")
                .noargs();
    }
    @Bean("bindingQueueToExchangeAsync")
    public Binding bindingQueueToExchangeAsync(@Qualifier(QUEUE_ASYNC)Queue queue,@Qualifier(EXCHANGE_ASYNC)Exchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("bc.async.#")
                .noargs();
    }
}
