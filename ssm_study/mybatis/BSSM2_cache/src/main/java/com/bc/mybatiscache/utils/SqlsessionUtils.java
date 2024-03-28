package com.bc.mybatiscache.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlsessionUtils {
    public static SqlSession getSqlSSession(){
        SqlSession sqlSession=null;
        try {
            InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
           sqlSession=sqlSessionFactory.openSession(true);//写true在创建sql语句时自动提交
        } catch (IOException e) {
            e.printStackTrace();
        }
         return sqlSession;
    }

}
