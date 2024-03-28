package com.bc.controller;

import com.bc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ParamController {
    //使用Servlet的API，需要在控制器方法形参中设置HttpServletRequest类型和参数，执行时在DispatcherServlet匹配到该方法时为request赋值
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        System.out.println("username:"+username+",passwd:"+passwd);
        return "hello";
    }
    //通过控制器方法的形参获取请求参数
    @RequestMapping("/param")
    public String getParamByController(String username,String passwd){
        System.out.println("username:"+username+",passwd:"+passwd);
        return "hello";
    }
    //通过控制器方法的形参获取请求参数,但参数名和形参名不同导致获取参数值为null
    //@RequestParam:请求参数 设置控制器和请求参数的映射关系
            //required:默认值为true。为true时该请求参数必须被传递
            //defaultValue:在没被传参的情况下给请求参数一个默认值(和required属性值无关)
    //@RequestHeader:获取请求头信息(不写注解直接使用referer形参获取时会默认获取请求参数叫referer的值,而不是请求头信息)
    @RequestMapping("/paramButDifferentName")
    public String getParamByControllerButDifferentName(@RequestParam(value = "name",required = true,defaultValue ="huhu") String username,
                                                       String passwd,
                                                       @RequestHeader("referer") String referer,
                                                       @CookieValue("JSESSIONID")String jsessionId){
        System.out.println("username:"+username+",passwd:"+passwd+",referer:"+referer);
        System.out.println("jsessionId的cookie:"+jsessionId);
        return "hello";
    }
    //通过pojo实体类获取请求参数
    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "hello";
    }
}
