import mapper.DeptMapper;
import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Emp;
import utils.SqlsessionUtils;

import java.util.ArrayList;
import java.util.List;

public class DynamicTest {
    SqlSession sqlSession;
    EmpMapper empMapper;

    @Before
    public void insertSqlSession(){
        sqlSession= SqlsessionUtils.getSqlSSession();
        empMapper=sqlSession.getMapper(EmpMapper.class);

    }
    @After
    public void closeSqlSession(){
        sqlSession.close();
    }
    @Test
    public void getEmpByCondition(){
        Emp emp=new Emp(7369, "SMITH", null, 0, null, null, null, 0);
        List<Emp>empList=empMapper.getEmpByCondition(emp);
        empList.forEach(System.out::println);
    }

    @Test
    public void getEmpByConditionSolveAndProblemOne(){
        Emp emp=new Emp(0, "SMITH", null, 0, null, null, null, 0);
        List<Emp> empList=empMapper.getEmpByConditionSolveAndProblemOne(emp);
        empList.forEach(System.out::println);
    }
    @Test
    public void getEmpByConditionSolveAndProblemTwo(){
        Emp emp=new Emp(0, "SMITH", null, 0, null, null, null, 0);
        List<Emp> empList=empMapper.getEmpByConditionSolveAndProblemTwo(emp);
        empList.forEach(System.out::println);
    }
    @Test
    public void getEmpByConditionSolveAndProblemThree(){
        Emp emp=new Emp(0, "", null, 0, null, null, null, 0);
        List<Emp> empList=empMapper.getEmpByConditionSolveAndProblemTwo(emp);
        empList.forEach(System.out::println);

    }
    @Test
    public void getEmpByTrim(){
        Emp emp=new Emp(7369, "SMITH", null, 0, null, null, null, 0);
        List<Emp> empList=empMapper.getEmpByTrim(emp);
        empList.forEach(System.out::println);
    }
    @Test
    public void selectEmpByAnyParamChoose(){
        Emp emp=new Emp(7369, "SMITH", "CLERK", 0, null, null, null, 0);
        List<Emp> empList=empMapper.selectEmpByAnyParamChoose(emp);
        empList.forEach(System.out::println);
    }
    @Test
    public void insertManyEmp(){
        List<Emp> empList=new ArrayList<>();
        empList.add(new Emp(1111, "aaaaa", "Trytry", 0, null, null, null, 0));
        empList.add(new Emp(1122, "aaaaa222", "Trytry", 0, null, null, null, 0));
        empList.add(new Emp(1133, "aaaaa333", "Trytry", 0, null, null, null, 0));
        empMapper.insertManyEmp(empList);
    }
    @Test
    public void deleteManyEmp(){
        Integer[] empnolist=new Integer[]{1111,1122,1133};
        empMapper.deleteManyEmp(empnolist);
    }
}
