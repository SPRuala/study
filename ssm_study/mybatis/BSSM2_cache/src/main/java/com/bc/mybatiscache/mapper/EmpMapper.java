package com.bc.mybatiscache.mapper;

import com.bc.mybatiscache.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    //根据员工id查员工信息
    Emp getEmpByEmpno(@Param("empno")int empno);
}
