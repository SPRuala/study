package com.bc.spring.test;

import com.bc.spring.pojo.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {
//    直接通过自动装配通过ioc对应的配置文件spring-jdbc.xml为JdbcTemplate赋值
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加
    @Test
    public void testInsert(){
        String sql="insert into t_emp values(null,?,?,?,?)";
        //可变长参数列表给sql语句赋值
        jdbcTemplate.update(sql,"root",20,"女","123@123");
    }
    //删除
    @Test
    public void testDelete(){
        String sql="delete from t_emp where emp_id=?";
        jdbcTemplate.update(sql, 7935);
    }
    //修改
    @Test
    public void testUpdate(){
        String sql="update t_emp set age=? where emp_id=?";
        jdbcTemplate.update(sql, 12,7369);
    }
    //查询(查询一个对象)
    @Test
    public void testSelectById(){
        String sql="select * from t_emp where emp_id=?";
        //new BeanPropertyRowMapper<>():Bean=实体类,property=属性;把查询出的字段和实体类的属性做映射
                                        //有默认的映射关系:字段名和属性名一致时 直接赋值
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 7369);
        System.out.println(emp);

    }
    //查询(查询一个集合)
    @Test
    public void testSelectAll(){
        String sql="select * from t_emp";
        List<Emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        empList.forEach(System.out::println);
    }
    //查询(查询单行单列)
    @Test
    public void testCount(){
        String sql="select count(*) from t_emp";
        //要把单行单列的数据查询给一个对象(基本数据类型),故还使用queryForObject
        //没有占位符,不用给可变长参数列表赋值
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("count = " + count);
    }

}
