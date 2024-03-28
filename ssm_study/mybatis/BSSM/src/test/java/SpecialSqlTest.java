import mapper.SpecialSqlMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.User;
import utils.SqlsessionUtils;

import java.util.List;

public class SpecialSqlTest {
    SqlSession sqlSession;
    SpecialSqlMapper specialSqlMapper;
    @Before
    public void insertSqlSession(){
        sqlSession= SqlsessionUtils.getSqlSSession();
        specialSqlMapper=sqlSession.getMapper(SpecialSqlMapper.class);
    }
    @After
    public void closeSqlSession(){
        sqlSession.close();
    }
    @Test
    public void GetUserByLike(){
      List<User> resultlist=specialSqlMapper.GetUserByLike("b");
      resultlist.forEach(System.out::println);
    }
    @Test
    public void DeleteUser(){
        specialSqlMapper.DeleteUser("4,5");
    }
    @Test
    public void SelectAllAnyTable(){

       List<User> userlist=specialSqlMapper.SelectAllAnyTable("user");
       userlist.forEach(System.out::println);
    }
    @Test
    public void InsertUser(){
        User user=new User("10023", "哦哦哦");
        specialSqlMapper.InsertUser(user);
    }
}
