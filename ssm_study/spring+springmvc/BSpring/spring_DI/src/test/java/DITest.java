import com.bc.spring.pojo.Clazz;
import com.bc.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {
    @Test
    public void TestDIBySet(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=ioc.getBean("studentOne",Student.class);
        System.out.println(student);
        Student student2=ioc.getBean("studentTwo", Student.class);
        System.out.println(student2);
    }
    @Test
    /*set注入ref引用*/
    public void TestDIBySetRef(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=ioc.getBean("studentThree",Student.class);
        System.out.println(student);
    }
    @Test
    /*set注入 级联赋值*/
    public void TestDIByCascading(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=ioc.getBean("studentFour", Student.class);
        System.out.println(student);
    }
    @Test
    /*set注入 内部bean*/
    public void TestDIByInnerBean(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=ioc.getBean("studentFive", Student.class);
        System.out.println(student);
    }
    @Test
    /*尝试获取内部bean（×）*/
    public void TestDIGetInnerBean(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz=ioc.getBean("clazzInner", Clazz.class);
        System.out.println(clazz);
    }
    /*set注入 array数组属性赋值*/
    @Test
    public void TestDIByArray(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=ioc.getBean("studentSix", Student.class);
        System.out.println(student);
    }
    /*set注入 list集合属性赋值*/
    @Test
    public void TestDIByList(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz=ioc.getBean("clazzTwo",Clazz.class );
        System.out.println(clazz);
    }
    /*set注入 引用List集合的bean/list集合约束*/
    @Test
    public void TestDIByListRefListBeanUtilList(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz=ioc.getBean("clazzThree", Clazz.class);
        System.out.println(clazz);
    }
    /*set注入 引用Map集合属性赋值*/
    @Test
    public void TestByMap(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=ioc.getBean("studentSeven", Student.class);
        System.out.println(student);
    }
    @Test
    /*set注入 引用Map集合的bean*/
    public void TestDIByMapREfUtilMap(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=ioc.getBean("studentEight", Student.class);
        System.out.println(student);
    }
    @Test
    /*set注入  p命名空间赋值*/
    public void TestDIByP(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=ioc.getBean("studentNine",Student.class);
        System.out.println(student);
    }
}
