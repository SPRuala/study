package com.bc.springboot.spring.bspringboot_yaml.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component:将实体类添加到Spring的组件中
@Component
@ConfigurationProperties(prefix = "dog")
public class Dog {
    private String lastName;
    private Integer age;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.lastName = name;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
