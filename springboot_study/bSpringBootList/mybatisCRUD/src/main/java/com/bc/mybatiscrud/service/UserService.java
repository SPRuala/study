package com.bc.mybatiscrud.service;

import com.bc.mybatiscrud.pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface UserService {

    /**
     * 新增user到数据库
     * @param user User对象
     */
     void saveUser(User user);

    /**
     * 根据主键查询信息
     * @param id id
     */
    User queryById(String id);

    /**
     *根据条件查询
     * @param name name
     * @param age age
     * @return list
     */
    List<User> queryByCondition(String name,Integer age);

    /**
     * 修改user到数据库
     * @param user user
     */
    int updateUser(User user);

    /**
     * 根据条件删除user
     * @param user user
     * @return 记录数
     */
    int deleteUser(User user);

    /**
     * 用于测试事务
     */
    void testTrans() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;

}
