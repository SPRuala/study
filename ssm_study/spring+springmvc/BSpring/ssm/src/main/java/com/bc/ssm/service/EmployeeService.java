package com.bc.ssm.service;

import com.bc.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    //查询所有员工信息
    List<Employee> getAllEmployee();
}
