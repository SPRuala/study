package com.example.makeexceptionandinterceptorfront.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //生成get和set方法
@NoArgsConstructor //生成默认构造函数
@AllArgsConstructor //生成全参构造函数
@ToString //生成toString方法
public class Student {
    private Integer sid;
    private String sname;
    private Integer age;
}
