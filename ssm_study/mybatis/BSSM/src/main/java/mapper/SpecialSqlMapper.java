package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface SpecialSqlMapper {
    //根据用户名进行模糊查询（结果条数不固定）
    List<User> GetUserByLike(@Param("anyname") String anyname);

    //批量删除
    void DeleteUser(@Param("id") String id);

    //动态设置表名(表字段相同不知道查哪个时可以用)
    List<User> SelectAllAnyTable(@Param("tablename") String tablename);

    //添加功能获取自增主键（在两个表为1：m的关系中，为m的那方设置主键）
    void InsertUser(User user);//实体类通过参数名可以获得参数值，所以不需要再注释@parame
}
