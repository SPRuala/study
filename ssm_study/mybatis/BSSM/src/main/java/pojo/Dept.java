package pojo;

import java.util.List;

public class Dept {
    /*在查询中把结果通过反射对应到属性名*/
    private int deptId;
    private String deptName;
    private List<Emp> emps;

    public Dept(int deptId, String deptName,List<Emp> emps) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.emps=emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Dept(){

    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
