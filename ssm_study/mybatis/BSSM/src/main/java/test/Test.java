package test;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;
import utils.SqlsessionUtils;

import java.io.InputStream;

public class Test {
    public static void testInsert()throws Exception{
        //获取核心文件输入流
        InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlsessionFactoryBuilder对象//获取SqlSessionFactory对象
        //使用Mybatis的连接工厂SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //获取数据库的连接SqlSession
        SqlSession session = factory.openSession();

        //获取UserMapper的代理实现类(接口 代理模式) 通过接口找到映射文件
      UserMapper userMapper= session.getMapper(UserMapper.class);
      //调用mapper接口中的方法 添加用户
        int result=userMapper.InsertUser();
        System.out.println("结果："+result);
        //提交事务
        session.commit();
        session.close();


    }

public static User SelectUserById(){
    User user=null;
    SqlSession sqlSession=SqlsessionUtils.getSqlSSession();
    UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    user = userMapper.SelectUserById();
    sqlSession.close();
    return user;
}

    public static void main(String[] args) {
        try {
//            Test.testInsert();
            System.out.println(Test.SelectUserById());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


