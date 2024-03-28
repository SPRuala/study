package com.bc.spring.pojo;

public class User {
//    private int eno, age;
    private String name;
    private String id;

    public User(){
        System.out.println("生命周期1：实例化");
    }

    public User(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        System.out.println("生命周期2：依赖注入");
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
    public void initMethod(){
        System.out.println("生命周期3：初始化");
    }
    public void destroy(){//销毁的生命周期在ioc容器关闭时才会执行
        System.out.println("生命周期4：(使用)销毁");
    }
}
