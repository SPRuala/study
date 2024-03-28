import com.bc.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireXMLTest {
    @Test
    public void testAutoWire(){
        //手动
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController=ioc.getBean(UserController.class);
        userController.saveUser();

    }
}
