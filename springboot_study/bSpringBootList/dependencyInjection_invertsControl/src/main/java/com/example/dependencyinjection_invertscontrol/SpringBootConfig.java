package com.example.dependencyinjection_invertscontrol;

import com.example.dependencyinjection_invertscontrol.pojo.Stu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration: 标识该类和配置相关
@Configuration
public class SpringBootConfig{
    //自定义bean加入到容器
    @Bean
    public Stu stu(){
        return new Stu("jack", 18);
    }
}
