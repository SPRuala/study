package com.bc.springmvc.config;


import com.bc.springmvc.interceptor.FirstInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;
import java.util.Properties;

//Springmvc的配置类,代替springmvc的配置文件
//WebMvcConfigurer不需要重写方法,有默认的方法体
/*springmvc配置内容:
*               扫描控制层组件 : @ComponentScan("com.bc.springmvc.controller")
*               视图解析器 : ITemplateResolver、templateEngine、viewResolver
*               默认的servlet处理静态资源 : configureDefaultServletHandling
*               mvc注解驱动 : @EnableWebMvc
*               视图控制器 : addViewControllers
*               文件上传解析器 : multipartResolver(自定义方法/Bean)
*               拦截器 : addInterceptors
*               异常解析器 : configureHandlerExceptionResolvers
* */
@Configuration
@ComponentScan("com.bc.springmvc.controller")
@EnableWebMvc //开启mvc注解驱动
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//.enable: 方法可用
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加一个视图控制器
        registry.addViewController("/").setViewName("index");//处理浏览器发送的请求,如果为"/",逻辑视图为index
    }

    @Bean //将方法的返回值作为Bean进行管理,Bean的id为该方法的方法名multipartResolver
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

    //registry: 拦截器的注册器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        FirstInterceptor firstInterceptor=new FirstInterceptor();
        registry.addInterceptor(firstInterceptor).addPathPatterns("/**");//.addInterceptor()注册一个拦截器; .addPathPatterns拦截路径
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        //创建异常处理器
        SimpleMappingExceptionResolver exceptionResolver=new SimpleMappingExceptionResolver();
        //设置属性
        Properties properties=new Properties();
        //properties中设置异常映射
        properties.setProperty("java.lang.ArithmeticException","error");//设置要处理的异常(key="要处理的异常",v="跳转的路径")
        exceptionResolver.setExceptionMappings(properties);
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);//将异常处理器添加到方法的参数集合中
    }

    //配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationcontext = ContextLoader.getCurrentWebApplicationContext();
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(webApplicationcontext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }
    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    //生成视图解析器并为解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

}
