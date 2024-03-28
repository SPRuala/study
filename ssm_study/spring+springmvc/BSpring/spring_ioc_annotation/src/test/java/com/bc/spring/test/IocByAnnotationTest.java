package com.bc.spring.test;

import com.bc.spring.controller.UserController;
import com.bc.spring.dao.UserDao;
import com.bc.spring.service.UserService;
import org.testng.annotations.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocByAnnotationTest {
    //把类交给ioc容器管理需要的注解：
    //加上这些注解 并扫描后 就可以将加上注解的类作为一个bean被ioc容器管理
        //@Component：将类标识为普通组件
        //@Controller：将类标识为控制层组件
        //@Service：将类标识为业务层组件
        //@Repository：将类标识为持久层组件
    //@Controller、@Service、@Repository都是由@Component扩展出来的
    //对于spring来说以上注解没有区别
    @Test
    public void AnnotationTest(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        //将类交给ioc管理后，可通过ioc获取该类的对象
        //调用了 标记常用 的扫描
       UserController userControlle=ioc.getBean("controllerId",UserController.class);
       UserService userService=ioc.getBean(UserService.class);//获取的对象可以是实现了接口的对象
       UserDao userDao=ioc.getBean(UserDao.class);
        System.out.println(userControlle);
        System.out.println(userService);
        System.out.println(userDao);
    }
    //设置注解扫描后使用@Autowired进行自动装配，不需要再通过ioc获取每个类的对象
    @Test
    public void IocByAutowired(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController=ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
