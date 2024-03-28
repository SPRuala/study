package com.bc.mybatiscrud.utils.exception.getthrow;

import com.bc.mybatiscrud.utils.exception.myexception.UserException;

public class GraceException {
    public  static void displayException(String errorMassage){
        throw new UserException(errorMassage);
    }
}
