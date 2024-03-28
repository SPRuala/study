package com.bc.spring.test;

import com.bc.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest {
    //直接通过自动装配的方式访问ioc中的bean
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        //userId为1的用户买bookId为1的图书(出现余额不足的错误)
        bookController.buyBook(1, 1);
    }
    @Test
    public void testBuyManyBook(){
        //userId为1的用户买bookId为1和2的图书(余额只够买1本)
        bookController.checkOut(1, new Integer[]{1,2});
    }
}
