package com.bc.springboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//mo: mongodb实体类
//@Document: mongodb中的映射,为document文档; 如果该表不存在,后续会根据其value值创建一张同名的表
@Document("students")
public class StudentMO {
    //@Id设置主键
    @Id
    private String stuId;
    //实体类中的属性需指定所映射的column(字段名)
    //@Field("字段名"):为属性添加所对应映射字段名
    @Field("name")
    private String name;
    @Field("sex")
    private String sex;
    @Field("age")
    private Integer age;

    public StudentMO() {
    }

    public StudentMO(String stuId, String name, String sex, Integer age) {
        this.stuId = stuId;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentMO{" +
                "stuId='" + stuId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
