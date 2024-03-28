package com.bc.mybatis.test;

import com.bc.mybatis.mapper.EmpMapper;
import com.bc.mybatis.pojo.Emp;
import com.bc.mybatis.utils.SqlsessionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;

import java.util.List;

public class MBGTest {
    @Before
    public PageInfo<Emp> testPage(){
        SqlSession sqlSession=SqlsessionUtils.getSqlSSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        //查询功能开始之前 开启分页功能
        PageHelper.startPage(2, 4);
        List<Emp>emps=empMapper.selectByExample(null);

        //查询功能后获取分页相关所有数据
        //第一个参数：分页查询结果的集合
        //第二个参数（navigatePages）:导航分页的页码数 eg：4
        PageInfo<Emp> pageInfo=new PageInfo<>(emps,4);


        return pageInfo;


    }
}
