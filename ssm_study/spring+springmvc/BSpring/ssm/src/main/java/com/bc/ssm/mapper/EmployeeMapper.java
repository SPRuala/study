package com.bc.ssm.mapper;

import com.bc.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    //查询所有员工信息
    List<Employee> getAllEmployee();

}
