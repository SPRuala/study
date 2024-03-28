package com.example.asynchronous.controller;

import com.example.asynchronous.utils.MyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class AsyncController {
    @Autowired
    private MyAsyncTask myAsyncTask;

    @ResponseBody
    @GetMapping("/tryAsyncTask")
    public Object tryAsyncTask(){
        myAsyncTask.publishMassage();//异步任务调用(因为是异步的,直接return "over")
        log.info("跳过异步任务的执行");
        return "over";
    }
}
