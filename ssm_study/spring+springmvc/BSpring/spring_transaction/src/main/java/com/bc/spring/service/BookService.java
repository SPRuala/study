package com.bc.spring.service;

public interface BookService {
    /**
     * 模拟买书
     * @param userId
     * @param bookId
     */
    void buyBook(Integer userId,Integer bookId);
}
