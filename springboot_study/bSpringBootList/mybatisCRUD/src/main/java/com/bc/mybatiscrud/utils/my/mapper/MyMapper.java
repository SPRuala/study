package com.bc.mybatiscrud.utils.my.mapper;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/*继承自己的MyMapper*/
//继承了Mapper和MysqlMapper
//Mapper:提供了BaseMapper(基础sql的crud语句)、ExampleMapper(条件crud)、RowBoundsMapper(动态sql)、
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
