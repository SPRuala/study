package com.bc.mybatiscrud.service.impl;

import com.bc.mybatiscrud.mapper.UserMapper;
import com.bc.mybatiscrud.pojo.User;
import com.bc.mybatiscrud.service.UserService;
import com.bc.mybatiscrud.utils.makeid.IDMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User queryById(String id) {
        User user= userMapper.selectByPrimaryKey(id);//根据主键进行查询
        return user;
    }

    @Override
    public List<User> queryByCondition(String name, Integer age) {
        //实例化example,传入查询的类
        Example example=new Example(User.class);
        //构造条件
        Example.Criteria criteria = example.createCriteria();
        //通过条件构造一些参数 property:匹配的字段/属性名; value:property对应的值
        //where name=#{name} and age=#{age}
        criteria.andEqualTo("name", name);
        criteria.andEqualTo("age", age);
        List<User> userList = userMapper.selectByExample(example);

        //————————————————————————————————————————————条件查询2
        //条件对象
        User user=new User(null, name, age);
        //使用.select方法直接传入一个条件对象
        //使用对象时,所有查询条件都为等于 (要实现>=或模糊查询等 则必须使用Example实现)
        List<User> users = userMapper.select(user);
        return userList;
    }

    @Override
    public int updateUser(User user) {
        //.updateByExample: 根据条件修改
        //.updateByPrimaryKey: 根据主键修改 (user中属性如果不写会造成修改为null值)
        //.updateByPrimaryKeySelective: 根据值修改,有什么值就会更新什么值 (user中属性如果不写不会造成修改为null值)
        //返回值 int i: 影响的记录数
        int i = userMapper.updateByPrimaryKey(user);
        return i;//将记录数返回
    }

    @Override
    public int deleteUser(User user) {
        //1.根据主键删除
//        int i = userMapper.deleteByPrimaryKey(user);
        //2.根据对象中的属性值匹配做条件删除
//        int i = userMapper.delete(user);
        //3.根据构建的example进行条件删除
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", user.getName());
        int i = userMapper.deleteByExample(example);
        return i;
    }

    @Transactional(propagation = Propagation.REQUIRED)//事务注解,事务类型:枚举
    @Override
    public void testTrans() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        //执行添加操作
        User user = new User(IDMaker.customizePrefix("bc", "onlyNum", 8),"测试回滚_添加",10);
        userMapper.insert(user);
        //模拟发生异常
        int a=9/0;
        //修改数据
        User userUpdate = new User("bc97610573", "修改测试1", null);
        userMapper.updateByPrimaryKeySelective(userUpdate);
    }

}
