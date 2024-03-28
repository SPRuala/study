package pojo;

public class User {
//    private int eno, age;
    private String name;
    private String id;

    public User(){

    }

    public User( String id,String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }


}
