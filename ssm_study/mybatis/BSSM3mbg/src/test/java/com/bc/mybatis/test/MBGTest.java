package com.bc.mybatis.test;

import com.bc.mybatis.mapper.EmpMapper;
import com.bc.mybatis.pojo.Emp;
import com.bc.mybatis.pojo.EmpExample;
import com.bc.mybatis.utils.SqlsessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        //将条件值设为null 查询所有
       List<Emp> emps=empMapper.selectByExample(null);
       emps.forEach(System.out::println);
    }
    @Test
    public void testMBG2(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        //根据员工姓名查询
        EmpExample empExample=new EmpExample();
        empExample.createCriteria().andEnameEqualTo("ADAMS");//创建条件对象
        List<Emp> emps=empMapper.selectByExample(empExample);
        emps.forEach(System.out::println);
    }
    @Test
    public void testMBG3(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);

        //有多个查询条件 ename="ADAMS"和sal>=1100
        EmpExample empExample=new EmpExample();
        empExample.createCriteria().andEnameEqualTo("ADAMS").andSalGreaterThanOrEqualTo(1100.0F);
        //条件中想使用or而不是and
        //用or和上面条件链接
        empExample.or().andDeptnoEqualTo(20);

        List<Emp> emps=empMapper.selectByExample(empExample);
        emps.forEach(System.out::println);
    }

    @Test
    public void testMBG4(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);

        //普通修改功能
        Emp emp=new Emp(1000, "zsb", "sleep", null, null, 800.0F, null, 20);

        EmpExample empExample=new EmpExample();
        empExample.createCriteria().andEmpnoEqualTo(1000);

        empMapper.updateByExample(emp,empExample);

    }
    @Test
    public void testMBG5(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);

        //选择性修改
        Emp emp=new Emp(null, "zhusubao", "eat", null, null, null, null, null);

        EmpExample empExample=new EmpExample();
        empExample.createCriteria().andEmpnoEqualTo(1000);

        empMapper.updateByExampleSelective(emp,empExample);

    }
}
