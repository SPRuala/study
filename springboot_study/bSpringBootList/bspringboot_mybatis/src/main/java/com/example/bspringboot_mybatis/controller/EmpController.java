package com.example.bspringboot_mybatis.controller;

import com.example.bspringboot_mybatis.pojo.Emp;
import com.example.bspringboot_mybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;


    @GetMapping("/getEmpByEmpno")
    public Emp getEmpByEmpno(@RequestParam("empno") Integer empno){
        return empService.getEmpByEmpno(empno);
    }

    @GetMapping("/insertEmp")
    public void insertEmp(){
        Emp emp = new Emp(1, "aoe", null, null, null, null, null, null);
        empService.insertEmp(emp);
    }
}
