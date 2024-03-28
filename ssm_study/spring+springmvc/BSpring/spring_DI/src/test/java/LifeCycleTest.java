import com.bc.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    @Test
    public void lifeCycle(){
        //ConfigurableApplicationContext为ApplicationContext的子接口，扩展了使ioc容器关闭和刷新的方法
        ConfigurableApplicationContext ioc=new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user=ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();//由ConfigurableApplicationContext提供
    }
}
