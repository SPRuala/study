package com.bc.ssm.service.impl;

import com.bc.ssm.mapper.EmployeeMapper;
import com.bc.ssm.pojo.Employee;
import com.bc.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }
}
