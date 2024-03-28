package com.example.makeerrorpage.utils;

import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice: 统一异常拦截处理(aop),为Controller服务;针对异常自定义处理和捕获,返回指定类型(json类型返回到前端)
@ControllerAdvice
public class GraceExceptionHandler {
    //@ExceptionHandler: 拦截什么异常
    @ResponseBody
    @ExceptionHandler(MissingRequestCookieException.class)
    public JsonResult returnNotFoundPageException(MissingRequestCookieException e){
        return JsonResult.normalError("缺少cookie");
    }

}