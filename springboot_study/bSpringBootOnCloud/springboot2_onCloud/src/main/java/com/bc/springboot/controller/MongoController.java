package com.bc.springboot.controller;

import com.bc.springboot.dao.StuDao;
import com.bc.springboot.entity.StudentMO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/mongo")
@RestController
public class MongoController {
    @Autowired
    private StuDao stuDao;
    @GetMapping("/add")
    public String add(){
        //实例化一个mo对象
        StudentMO studentMO = new StudentMO("1001","Jack","男",20);
        //保存/添加(或更新) 数据; 当数据主键已存在时,save为更新功能,当数据主键不存在时,save为插入功能
        //.save:MongoRepository中集成的通用的便捷api之一
        stuDao.save(studentMO);
        return "create ok";
    }
    @GetMapping("/select")
    public Object select(String id){
        //查询(根据id) 数据
        //返回Optional<T>; T为数据类型
        Optional<StudentMO> op = stuDao.findById(id);
        //op.get()直接获取一个查询到的对象
        StudentMO studentMO = op.get();
        System.out.println("studentMO = " + studentMO);
        return studentMO;
    }
    @GetMapping("/update")
    public String update(){
        //实例化一个mo对象
        StudentMO studentMO = new StudentMO("1001","AA","女",22);
        //保存/添加(或更新) 数据; 当数据主键已存在时,save为更新功能,当数据主键不存在时,save为插入功能
        stuDao.save(studentMO);
        return "update ok";
    }
    @GetMapping("/delete")
    public String delete(String id){
        stuDao.deleteById(id);//根据id删除
        // stuDao.deleteAll();//直接删除所有
        //stuDao.delete();//value=xxMO 根据特定的mo条件
        return "delete ok";
    }
}
