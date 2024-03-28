import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource druidDataSource=ioc.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getConnection());
    }
}
