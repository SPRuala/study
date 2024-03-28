package com.bc.controller;

import com.bc.dao.EmployeeDao;
import com.bc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
/*
* 查询所有员工信息-->/employee-->get
* 跳转到添加页面-->to/add-->get
* 新增员工-->/employee-->post
* 跳转到修改页面-->/employee/1-->get
* 修改员工信息-->/employee-->put
* 删除员工信息-->/employee/1-->delete
* */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    //获取所有员工信息
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> allEmployee= employeeDao.getAll();
        model.addAttribute("allEmployee", allEmployee);
        return "allEmployee";
    }
    //添加员工
    //用了th:
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //跳转去列表功能 /employee
        //浏览器重新发送请求(重定向)
        return "redirect:/employee";
    }
    //更新
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        //根据id查询员工信息
        Employee employee = employeeDao.get(id);
        //将员工信息共享到请求域
        model.addAttribute("employee", employee);
        return "employeeUpdate";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        //修改员工信息
        //持久层中Map同键替换
        employeeDao.save(employee);
        System.out.println(employee);
        //重定向到列表功能 /employee
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        System.out.println(id);
        //重定向到列表功能 /employee
        return "redirect:/employee";
    }
}
