package com.example.makeexceptionandinterceptorfront.exception;

//处理异常,进行调用
public class GraceException {
    public static void displayException(String errorMassage){
        throw new StudentException(errorMassage);
    }
}
