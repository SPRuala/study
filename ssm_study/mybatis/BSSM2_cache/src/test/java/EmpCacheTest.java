import com.bc.mybatiscache.mapper.EmpMapper;
import com.bc.mybatiscache.pojo.Emp;
import com.bc.mybatiscache.utils.SqlsessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;


/*
缓存查询顺序：
    *先查二级缓存（范围大 二级缓存可能有其他Sqlsession查出来的数据）
    *二级缓存没命中 再查一级缓存
    *一级缓存没命中 再查数据库
*/
public class EmpCacheTest {
    /*一级缓存*/
//	默认开启（搭建了框架就默认使用）
//	为SqlSession级别 ：在使用同一个SqlSession再次查询相同数据时不会从mysql中去查 而是在缓存中去获取
//			（在日志中可以查看：查询到两条结果，但只执行了一次sql）
      /*
      缓存失效4种情况：
      * 1.不同SqlSession对应不同一级缓存
      * 2.同一SqlSession不同查询条件
      * 3.同一SqlSession两次查询之间执行了增删改 任意一次增删改会清空当前缓存 （增删改会更新数据库）
      * 4.同一SqlSession之间手动清空缓存
      * */


    @Test
    public void getEmpByEmpno() {
        SqlSession sqlSession1 = SqlsessionUtils.getSqlSSession();
        EmpMapper empMapper1 = sqlSession1.getMapper(EmpMapper.class);
        //查询到两条结果，但只执行了一次sql
        Emp emp1 = empMapper1.getEmpByEmpno(7369);
        System.out.println(emp1);
        /*缓存失效3*/
        //若在这进行增删改 会把emp1的缓存清空，emp2会再次执行sql语句
        /*缓存失效4*/
        sqlSession1.clearCache();//clearCache清空缓存
        Emp emp2 = empMapper1.getEmpByEmpno(7369);
        System.out.println(emp2);
        //获取第二个SqlSession和Mapper
        SqlSession sqlSession2 = SqlsessionUtils.getSqlSSession();
        EmpMapper empMapper2 = sqlSession2.getMapper(EmpMapper.class);
        //使用第二个SqlSession和Mapper 会重新从mysql中去查（再次调用执行sql语句）
        /*缓存失效1*/
        Emp emp3 = empMapper2.getEmpByEmpno(7369);
        System.out.println(emp3);

    }

    /*二级缓存*/
//为SqlSessionFactory级别，同一个SqlSessionFactory提供的不同SqlSession也会被缓存
     /*
        开启条件：
        * 1.核心配置文件 全局配置cacheEnable="true" 默认为true 不需要另外设置
        * 2.映射文件配置<cache/>
        * 3.必须在SqlSession关闭或提交后有效 未关闭/提交之前查询结果会被保存到一级缓存
        * 4.查询数据的实体类必须实现序列化接口
        * */
        /*
        失效条件：
        * 两次查询之间执行增删改操作
        */
//缓存命中率（Cache Hit Ratio）：和数据总数有关 输出不是0时说明 当前缓存被命中 当前数据在缓存中存在


    /*测试二级缓存*/
//    不能使用工具类：每次调用工具类会创建不同的SqlSessionFactory实例
    @Test
    public void testCacheLevel2() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //保证sqlsession由同一个sqlSessionFactory提供
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        EmpMapper empMapper1 = sqlSession1.getMapper(EmpMapper.class);
        Emp emp1 = empMapper1.getEmpByEmpno(7369);
        System.out.println(emp1);
        sqlSession1.close();//操作关闭
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        EmpMapper empMapper2 = sqlSession2.getMapper(EmpMapper.class);
        Emp emp2 = empMapper2.getEmpByEmpno(7369);
        System.out.println(emp2);
        sqlSession2.close();
    }
}
