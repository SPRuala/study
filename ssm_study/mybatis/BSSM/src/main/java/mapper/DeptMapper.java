package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;

import java.util.List;

public interface DeptMapper {
    Dept getDeptByDeptId(@Param("deptId")int deptId);
    //多对一
    //通过分步查询获取员工和部门信息（第二步）
    Dept getEmpAndDeptByStepMethoudThreeSteptwo(@Param("deptId")int deptId);

    //一对多
    //根据deptId查询dept信息和该部门中所有员工信息
    Dept getDeptAndEmpByDeptId(@Param("deptId") int deptId);//把谁写前面谁做主表
    //通过分步查找dept信息和该部门中员工信息（第一步）
    Dept getDeptAndEmpByDeptIdStepone(@Param("deptId")int deptId);
}
