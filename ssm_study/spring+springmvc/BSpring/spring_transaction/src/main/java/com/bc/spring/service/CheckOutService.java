package com.bc.spring.service;

public interface CheckOutService {
    /**
     * 用户买多本书(结账)
     * @param userId
     * @param bookIds
     */
    void checkOut(Integer userId,Integer[] bookIds);
}
