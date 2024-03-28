package com.bc.mybatiscrud.utils.exception.myexception;

public class UserException extends RuntimeException{
    public  UserException(String errorMassage){
        super(errorMassage);
    }
}
