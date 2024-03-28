package com.bc.spring.service.impl;

import com.bc.spring.service.BookService;
import com.bc.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckOutServiceImpl implements CheckOutService {
    @Autowired
    private BookService bookService;
    @Transactional
    @Override
    public void checkOut(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(userId, bookId);
        }    
    }
}
