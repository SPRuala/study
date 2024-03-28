package com.bc.springmvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//web的初始化类,代替web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //配置一个配置类代替spring的配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //Spring的配置类可以有多个
        return new Class[]{SpringConfig.class};
    }

    //设置一个配置类代替springmvc的配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        //Springmvc的配置类可以有多个
        return new Class[]{WebConfig.class};
    }

    //设置springmvc的前端控制器DispactherServlet的url-pattern(需要请求的前段路径)
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //配置过滤器
    @Override
    protected Filter[] getServletFilters() {
        //创建编码过滤器
        CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        //创建处理请求方式过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter=new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}
