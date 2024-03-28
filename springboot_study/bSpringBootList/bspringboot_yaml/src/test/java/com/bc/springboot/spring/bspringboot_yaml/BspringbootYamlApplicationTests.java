package com.bc.springboot.spring.bspringboot_yaml;

import com.bc.springboot.spring.bspringboot_yaml.pojo.Dog;
import com.bc.springboot.spring.bspringboot_yaml.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BspringbootYamlApplicationTests {
    @Autowired
    private Dog dog;
    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        System.out.println("dog = " + dog);
        System.out.println("person = " + person);
    }

}
