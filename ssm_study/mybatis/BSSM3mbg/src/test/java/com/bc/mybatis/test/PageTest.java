package com.bc.mybatis.test;

import com.bc.mybatis.mapper.EmpMapper;
import com.bc.mybatis.pojo.Emp;
import com.bc.mybatis.utils.SqlsessionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {
    /*分页相关所有数据：*/
    /*有需要可以直接访问*/
/*
    PageInfo{
    pageNum=1,当前页的页码             pageSize=4,设置每页显示的条数     size=4,当前页展示的真实条数（最后一页有可能不到设置条数）
    startRow=1,当前页第几行开始         endRow=4,到第几行结束            total=15,总共多少条数据
    pages=4,总共多少页

    PageInfo中封装了Page对象
    list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=15, pages=4, reasonable=false, pageSizeZero=false}
    [Emp{empno=7369, ename='SMITH', job='CLERK', mgr=7902, hiredate=Wed Dec 17 00:00:00 CST 1980, sal=800.0, comm=800.0, deptno=20}, Emp{empno=7499, ename='ALLEN', job='SALESMAN', mgr=7698, hiredate=Fri Feb 20 00:00:00 CST 1981, sal=1600.0, comm=300.0, deptno=30}, Emp{empno=7521, ename='WARD', job='SALESMAN', mgr=7698, hiredate=Sun Feb 22 00:00:00 CST 1981, sal=1250.0, comm=500.0, deptno=30}, Emp{empno=7566, ename='JONES', job='MANAGER', mgr=7839, hiredate=Thu Apr 02 00:00:00 CST 1981, sal=2975.0, comm=null, deptno=20}],

    prePage=0,上一页的页码              nextPage=2,下一页的页码                isFirstPage=true, 是否是第一页
    isLastPage=false,是否是最后一页                    hasPreviousPage=false,是否有上一页
    hasNextPage=true,是否有下一页                      navigatePages=5,当前导航分页页码数
    navigateFirstPage=1,导航分页第几页开始              navigateLastPage=4, 导航分页第几页结束
    navigatepageNums=[1, 2, 3, 4]}导航分页的页码
*/

    @Test
    public void testPage(){
       SqlSession sqlSession=SqlsessionUtils.getSqlSSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        //查询功能开始之前 开启分页功能
        PageHelper.startPage(2, 4);
       List<Emp>emps=empMapper.selectByExample(null);

       //查询功能后获取分页相关所有数据
        //第一个参数：分页查询结果的集合
        //第二个参数（navigatePages）:导航分页的页码数 eg：4
        PageInfo<Emp>pageInfo=new PageInfo<>(emps,4);
        System.out.println(pageInfo);


       emps.forEach(System.out::println);



    }
}
