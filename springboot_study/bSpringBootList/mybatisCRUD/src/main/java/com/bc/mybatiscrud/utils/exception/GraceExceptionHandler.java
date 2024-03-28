package com.bc.mybatiscrud.utils.exception;

import com.bc.mybatiscrud.utils.exception.myexception.UserException;
import com.bc.mybatiscrud.utils.exception.result.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice: 统一异常拦截处理(aop)
@ControllerAdvice
public class GraceExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserException.class)
    public JsonResult normalException(UserException e){
        return JsonResult.normalError(e.getMessage());
    }
}
