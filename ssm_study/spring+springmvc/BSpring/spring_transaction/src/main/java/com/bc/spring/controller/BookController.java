package com.bc.spring.controller;

import com.bc.spring.service.BookService;
import com.bc.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckOutService checkOutService;

    //模拟买书功能    参数列表:买书的人,书的id
    public void buyBook(Integer userId,Integer bookId){
     bookService.buyBook(userId,bookId);
    }

    //用户要买多本书
    public void checkOut(Integer userId,Integer[] bookIds){
        checkOutService.checkOut(userId,bookIds);
    }
}
