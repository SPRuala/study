package com.example.bspringboot_mybatis.service;

import com.example.bspringboot_mybatis.mybatis.mapper.EmpMapper;
import com.example.bspringboot_mybatis.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired
    EmpMapper empMapper;

    public Emp getEmpByEmpno(Integer empno){
        return empMapper.getEmpByEmpno(empno);
    }

    public void insertEmp(Emp emp){
        empMapper.insertEmp(emp);
    }
}
