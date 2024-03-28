package com.bc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/redis")
@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/add")
    public String add(String key,String value){
        //.opsForValue()普通数据类型
        //.set(k,v)设值
        stringRedisTemplate.opsForValue().set(key, value);
        return "创建成功";
    }
    @GetMapping("/get")
    public String get(String key){
        //.get() 做相应的获取; 返回类型为V,可以使用强转转为String
        //根据key获取对应的值
       return stringRedisTemplate.opsForValue().get(key);
    }
    @GetMapping("/update")
    public String update(String key,String value){
        //Redis更新实质为添加后覆盖原有数据
        stringRedisTemplate.opsForValue().set(key, value);
        return "修改成功";
    }
    @GetMapping("/delete")
    public String delete(String key){
        //stringRedisTemplate.delete(key); 根据key删除(所有类型均可以通过该方法删除)
        stringRedisTemplate.delete(key);
        return "删除成功";
    }
}
