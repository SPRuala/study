package com.bc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*访问用户资源
* 路径统一 /user:表示用户资源的名词
* CRUD:
*       查询所有用户信息:/user-->get请求
*       根据id查询用户信息:/user/1(将id作为请求路径的一部分传输到服务器)-->get请求
*       添加用户信息:/user(数据较多,使用表单提交)-->post请求
*       修改用户信息:/user-->put
*       删除用户信息:/user/1-->delete
* */
@Controller
public class RestfulController {
    @RequestMapping(value = "user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息:/user-->get请求");
        return "success";
    }
    //rest传参方式
    //{}:占位符,通过占位符表示当前位置的值
    //@PathVariable:占位符的id赋值给形参进行绑定
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息:/user/"+id+"(将id作为请求路径的一部分传输到服务器)-->get请求");
        return "success";
    }
    @RequestMapping(value = "user",method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("添加用户信息:/user(数据较多,使用表单提交)-->post请求");
        return "success";
    }
    @RequestMapping(value = "user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息:/user-->put");
        return "success";
    }
    @RequestMapping(value = "user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除用户信息:/user/"+id+"-->delete");
        return "success";
    }
}
