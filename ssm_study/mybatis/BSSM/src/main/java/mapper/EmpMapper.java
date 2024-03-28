package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;
import pojo.Emp;

import java.util.List;

public interface EmpMapper {


    Emp getEmpAndDeptByEmpno(@Param("empno") int empno);

    Emp getEmpAndDeptByEmpnoMethoudOne(@Param("empno") int empno);

    Emp getEmpAndDeptByEmpnoMethoudTwo(@Param("empno")int empno);
    //通过分步查询获取员工和部门信息（第一步）
    Emp getEmpAndDeptByStepMethoudThreeStepone(@Param("empno")int empno);

    //通过分步查询查找部门信息和该部门所在的员工信息(第二步)
    List<Emp>getDeptAndEmpByDeptIdSteptwo(@Param("deptno")int deptno);

    //动态sql————————————————————————————————————————————————————————

    List<Emp> getEmpByCondition(Emp emp);
    //用恒成立条件避免多余and报错
    List<Emp> getEmpByConditionSolveAndProblemOne(Emp emp);
    //用where标签自动生成where关键字，自动去掉多余的and
    List<Emp> getEmpByConditionSolveAndProblemTwo(Emp emp);
    //where标签不起作用（没有条件成立的情况下）
    List<Emp> getEmpByConditionSolveAndProblemThree(Emp emp);
    //trim标签去除sql语句后的and（也可以在前面添加东西）
    List<Emp> getEmpByTrim(Emp emp);
    //choose标签
    List<Emp> selectEmpByAnyParamChoose(Emp emp);
    //foreach批量添加(使用Emp集合)
    void insertManyEmp(@Param("emplist") List<Emp> empList);
    //foreach批量删除(使用Integer数组)
    void deleteManyEmp(@Param("empnolist") Integer[] empnolist);
}
