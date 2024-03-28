package com.bc.pojo;

public class User {
    private Integer id;
    private String username;
    private String passwd;
    private Integer age;
    private String gender;

    public User(Integer id, String username, String passwd, Integer age, String gender) {
        this.id = id;
        this.username = username;
        this.passwd = passwd;
        this.age = age;
        this.gender = gender;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
