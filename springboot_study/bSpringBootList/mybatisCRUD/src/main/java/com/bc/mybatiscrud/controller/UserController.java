package com.bc.mybatiscrud.controller;

import com.bc.mybatiscrud.bo.UserBo;
import com.bc.mybatiscrud.pojo.User;
import com.bc.mybatiscrud.service.impl.UserServiceImpl;
import com.bc.mybatiscrud.utils.exception.result.JsonResult;
import com.bc.mybatiscrud.utils.makeid.IDMaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController{

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/get")
    public JsonResult getUser(String id){
        //根据id查询
        User user = userService.queryById(id);
        //todo: 这里打印的null是正常的,这个方法在apifox没被传id,/get时调用的是queryByCondition方法
        System.out.println(user);
        //根据条件查询
        List<User> userList = userService.queryByCondition("测试1", 11);
        return JsonResult.ok(userList);
    }
    @DeleteMapping("/delete")
    public JsonResult deleteUser(@RequestBody User user){
        user.setName("bo1");
        int i = userService.deleteUser(user);
        return JsonResult.dbOk(i);
    }
    @PutMapping("/update")
    public JsonResult updateUser(@RequestBody UserBo userBo){
        User user = new User();
        BeanUtils.copyProperties(userBo,user);
        int i = userService.updateUser(user);//返回值为int类型记录数
        return i>0? JsonResult.dbOk(user) : JsonResult.normalError("无效操作");
    }
    @PostMapping("/insert")
    public JsonResult insertUser(@Valid @RequestBody UserBo userBo, BindingResult bindingResult)throws Exception{
        if (bindingResult.hasErrors()){//判断BindingResult是否有错,包含了错误信息,如果有,直接return
            Map<String, String> errors = getErrors(bindingResult);//有错时调用getErrors获取错误信息和名字
            return JsonResult.errorMap(errors);
        }
        String id= IDMaker.customizePrefix("bc", "onlyNum", 8);
        //实例化数据层对象
        User user=new User();
        BeanUtils.copyProperties(userBo, user);//将一个对象拷贝到另一个对象(要求两个对象属性一致);当前bo只接了name和age,故不会拷贝id
        user.setId(id);

        userService.saveUser(user);
       return JsonResult.dbOk(user);
    }
    //Map<String,String> 使用键值对返回错误数据,k=String,v=错误信息(String)
    public Map<String,String> getErrors(BindingResult bindingResult){
        //bindingResult.getFieldErrors()为List形式,泛型为FieldError
        //拿到错误做for循环
        Map<String,String> map=new HashMap<>();
        List<FieldError> errorList = bindingResult.getFieldErrors();
        for (FieldError fieldError : errorList){
            String field = fieldError.getField();//获取属性的名字
            String message = fieldError.getDefaultMessage();//获取错误的消息
            map.put(field, message);
        }
        return map;
    }
    //测试事务
    @PostMapping("/testTrans")
    public JsonResult testTrans() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        userService.testTrans();
        return JsonResult.dbOk(null);
    }
}
