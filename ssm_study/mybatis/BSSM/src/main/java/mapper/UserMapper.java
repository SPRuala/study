package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.Map;

public interface UserMapper {

    int InsertUser();

    User SelectUserById();

    User SelectRamdon(String name);

    //参数为多个字面量类型
    User SelectUserByIdAndName(int id,String name);
    //用注解自定义map的键
    User SelectAllUserByParam(@Param("id") int id,@Param("name") String name);

    int SelectCount();

    //不清楚查询结果为什么类型时返回值用Map
    Map<String,Object> getUserByIdtoMap(@Param("id")int id);
}
