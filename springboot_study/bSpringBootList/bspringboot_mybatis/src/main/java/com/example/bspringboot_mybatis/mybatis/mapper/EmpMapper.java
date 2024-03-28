package com.example.bspringboot_mybatis.mybatis.mapper;

import com.example.bspringboot_mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmpMapper {

    Emp getEmpByEmpno(@Param("empno") Integer empno);

    /**
     * 添加emp
     * @param emp
     */
    void insertEmp(Emp emp);
}
