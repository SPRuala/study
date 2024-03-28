import mapper.DeptMapper;
import mapper.EmpMapper;
import mapper.SpecialSqlMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Dept;
import pojo.Emp;
import utils.SqlsessionUtils;

import java.util.List;

public class ResultMapTest {
    SqlSession sqlSession;
    EmpMapper empMapper;
    DeptMapper deptMapper;
    @Before
    public void insertSqlSession(){
        sqlSession= SqlsessionUtils.getSqlSSession();
        empMapper=sqlSession.getMapper(EmpMapper.class);
        deptMapper=sqlSession.getMapper(DeptMapper.class);
    }
    @After
    public void closeSqlSession(){
        sqlSession.close();
    }
    @Test
    public void getDeptByDeptId(){
      Dept dept=deptMapper.getDeptByDeptId(10);
        System.out.println(dept);
    }
    @Test
    public void getEmpAndDeptByEmpno(){
        Emp emp=empMapper.getEmpAndDeptByEmpno(7369);
        System.out.println(emp);
    }
    @Test
    public void getEmpAndDeptByEmpnoMethoudOne(){
        Emp emp=empMapper.getEmpAndDeptByEmpnoMethoudOne(7369);
        System.out.println(emp);
    }
    @Test
    public void getEmpAndDeptByEmpnoMethoudTwo(){
        Emp emp=empMapper.getEmpAndDeptByEmpnoMethoudTwo(7369);
        System.out.println(emp);
    }
    @Test
    public void getEmpAndDeptByStepMethoudThreeStep(){
        Emp emp=empMapper.getEmpAndDeptByStepMethoudThreeStepone(7369);
        System.out.println(emp.getDept());
        System.out.println(emp.getEname());

    }
    @Test
    public void getDeptAndEmpByDeptId(){
        Dept dept=deptMapper.getDeptAndEmpByDeptId(10);
        System.out.println(dept);
    }
    @Test
    public void getDeptAndEmpByDeptIdStep(){
        Dept dept=deptMapper.getDeptAndEmpByDeptIdStepone(10);
        System.out.println(dept);
    }
}
