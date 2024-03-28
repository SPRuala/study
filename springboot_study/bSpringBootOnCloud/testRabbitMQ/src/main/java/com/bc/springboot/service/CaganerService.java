package com.bc.springboot.service;

import java.lang.reflect.InvocationTargetException;

public interface CaganerService {
    //生成一坨屎
    String createPop() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;
    //将屎拉入MQ
    void pushPop(String popName);
   /* //用户拿出一坨屎
    String getPop(String payload, Message message);*/
    //开启拿屎用户
    void openPopConsumer(String consumerID);
    //关闭拿屎用户
    void closePopConsumer(String consumerID);
}
