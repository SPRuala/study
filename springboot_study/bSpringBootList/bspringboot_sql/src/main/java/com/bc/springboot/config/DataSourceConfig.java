package com.bc.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

//过时注解
@Deprecated
//@Configuration
public class DataSourceConfig {

    //默认的自动配置为: 容器中没有数据源时 才会配Hikari数据源; 现在容器中放置了一个Druid数据源,则配置Druid数据源
    //@ConfigurationProperties: 将配置文件中的spring.datasource和该bean组件绑定
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();

        //设置数据源的属性
        //druidDataSource.setUrl("");
        //druidDataSource.setUsername();
        //druidDataSource.setPassword();

        //通过配置文件获取数据源的属性值(需设置@ConfigurationProperties)
        //设置注解后,默认数据源的属性值均为配置文件中对应的spring.datasource属性值

        //开启Druid的sql监控功能(可以在yaml文件中配置)
        //druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    //配置Druid监控页功能
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //准备servlet
        StatViewServlet statViewServlet = new StatViewServlet();
        //构造器需传入一个servlet和该servlet所映射的路径(拦截的路径)
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        //监控页登录配置(对应的登录属性在初始化属性内,故添加初始化属性再设置登录相关属性)
        //设置允许登录到该监控页的用户名
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword", "123456");

        return statViewServletServletRegistrationBean;
    }

    //配置web-jdbc监控
    @Bean
    public FilterRegistrationBean webStatFilter(){
        //先创建一个WebStatFilter
        WebStatFilter webStatFilter=new WebStatFilter();
        //泛型WebStatFilter: 该Filter的类型为WebStatFilter
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        //设置拦截路径(要求传参为集合)
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        //设置排除的拦截路径(对应的exclusions排除属性在初始化属性内,故添加初始化属性再设置排除项)
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico./druid/*");

        return webStatFilterFilterRegistrationBean;
    }
}
