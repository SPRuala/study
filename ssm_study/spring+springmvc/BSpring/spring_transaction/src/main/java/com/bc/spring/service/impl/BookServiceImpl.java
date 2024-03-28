package com.bc.spring.service.impl;

import com.bc.spring.dao.BookDao;
import com.bc.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service

public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    //无事务:每个sql语句独占一个事务且自动提交,各自执行成功与否互不影响
    //事务:@Transactional被事务管理,sql语句们要么都成功要么都失败
    @Transactional(
            //readOnly = true
            timeout = 3,   //超时时间3秒
            //noRollbackFor = ArithmeticException.class,//数组类型数据,只有一个数据时{}可加可不加
            noRollbackForClassName ="java.lang.ArithmeticException",
            isolation = Isolation.DEFAULT,//一般情况下为.DEFAULT(当前所用数据库中默认的隔离级别)
            propagation = Propagation.REQUIRES_NEW
    )
    @Override
    public void buyBook(Integer userId, Integer bookId) {
        /*try{
            TimeUnit.SECONDS.sleep(5);//让程序休眠5秒.SECONDS:单位
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //查询图书的价格
        Integer price=bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId,price);
        //System.out.println(1/0);
    }
}
