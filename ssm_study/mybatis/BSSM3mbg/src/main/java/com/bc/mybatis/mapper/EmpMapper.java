package com.bc.mybatis.mapper;

import com.bc.mybatis.pojo.Emp;
import com.bc.mybatis.pojo.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Sun Oct 08 16:21:45 CST 2023
     */
    int countByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Sun Oct 08 16:21:45 CST 2023
     */
    int deleteByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Sun Oct 08 16:21:45 CST 2023
     */
    /*添加*/
    /*如果有属性为null 此方法会给该属性赋值为null*/
    /*有默认值的情况下 也会被赋值为null*/
    int insert(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Sun Oct 08 16:21:45 CST 2023
     */
    /*选择性添加*/
    /*如果有属性为null，且有默认值 不会为该属性（字段）赋值*/
    /*为null时有默认值的情况下 使用默认值*/
    int insertSelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Sun Oct 08 16:21:45 CST 2023
     */
    /*根据条件查询*/
    List<Emp> selectByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Sun Oct 08 16:21:45 CST 2023
     */
    /*根据条件选择性修改*/
    /*如果赋值时有属性为null 不会对该属性进行修改*/
    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Sun Oct 08 16:21:45 CST 2023
     */
    /*根据条件进行修改*/
    /*如果赋值时有属性为null 该属性会被修改为null*/
    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);
}