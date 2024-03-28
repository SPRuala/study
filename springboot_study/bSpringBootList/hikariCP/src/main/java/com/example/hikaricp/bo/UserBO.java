package com.example.hikaricp.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//bo:基于业务层使用的业务对象,由前端传进来,在controller操作后的对象;用于接收前端传进来的RequestBody对象,并将它复制赋给数据层对象
@Data
@ToString
@AllArgsConstructor //生成带参构造函数
@NoArgsConstructor
public class UserBO {
    private Integer id;
    private String name;
    private Integer age;


}
