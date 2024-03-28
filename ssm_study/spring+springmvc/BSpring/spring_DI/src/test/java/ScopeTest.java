import com.bc.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testScope(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-scope.xml");
        //通过同一个ioc容器获取student对象
        Student student=ioc.getBean(Student.class);
        Student student1=ioc.getBean(Student.class);
        //判断是否为同一对象
        System.out.println(student.equals(student1));//默认为单例模式


    }
}
