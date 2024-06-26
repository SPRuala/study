package com.bc.ssm.controller;

import com.bc.ssm.pojo.Employee;
import com.bc.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//查询所有的员工信息-->/employee-->get
//根据id查询某个员工信息-->/employee/1-->get
//跳转到添加页面-->/to/add-->get
//添加员工信息-->/employee-->post
//修改员工信息-->/employee-->put
//删除员工信息-->/employee/1-->delete
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //查询所有的员工信息
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
       List<Employee> employeeList=employeeService.getAllEmployee();
        model.addAttribute("employeeList",employeeList);
        System.out.println(employeeList);
        //跳转到employee_list.html
        return "employee_list";
    }
}
