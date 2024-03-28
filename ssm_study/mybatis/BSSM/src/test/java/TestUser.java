import mapper.UserMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.User;
import utils.SqlsessionUtils;

import java.util.Map;

public class TestUser {
    SqlSession sqlSession;
    UserMapper userMapper;

    @Before
    public void insertSqlSession() {
        sqlSession = SqlsessionUtils.getSqlSSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void CloseSqlSession() {
        sqlSession.close();
    }
    @Test
    public void SelectRamdon(){
        User user=userMapper.SelectRamdon("wxq");
        System.out.println(user);
    }
    @Test
    public void SelectUserByIdAndName(){
        User user=userMapper.SelectUserByIdAndName(1, "zsb");
        System.out.println(user);
    }
    @Test
    public void SelectAllUserByParam(){
        User user=userMapper.SelectAllUserByParam(1,"zsb");
        System.out.println(user);
    }
    @Test
    public void SelectCount(){
        int number=userMapper.SelectCount();
        System.out.println(number);
    }
    @Test
    public void getUserByIdtoMap(){
        Map<String,Object>resultmap=userMapper.getUserByIdtoMap(4);//查询结果以字段名为键以字段值为值
        System.out.println(resultmap);
    }
}

