package com.bc.mybatiscrud.mapper;

import com.bc.mybatiscrud.pojo.User;
import com.bc.mybatiscrud.utils.my.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;


//单独使用@Repository，需要配合使用MapperScannerConfigurer或者@MapperScan注解。
//单独使用@Mapper时，可能会在编辑器出现警告，不影响程序运行。可以配合使用@Repository消除警告。

@Mapper
//@Repository
public interface UserMapper extends MyMapper<User> {

}
