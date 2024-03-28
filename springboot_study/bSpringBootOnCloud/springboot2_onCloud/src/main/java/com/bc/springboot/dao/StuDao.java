package com.bc.springboot.dao;

import com.bc.springboot.entity.StudentMO;
import org.springframework.data.mongodb.repository.MongoRepository;

//使用JPA的方式进行数据层的操作,继承MongoRepository后可以使用通用的api方法进行开发
//MongoRepository<T,ID>:
    //T: 当前数据对象(mo); ID:主键类型(和 mo实体类/表 的主键相对应)
public interface StuDao extends MongoRepository<StudentMO,String> {

}
