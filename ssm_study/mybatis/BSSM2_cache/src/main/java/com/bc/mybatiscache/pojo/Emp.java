package com.bc.mybatiscache.pojo;

import java.io.Serializable;

public class Emp implements Serializable {
    private int empno,mgr,deptno;
    private String ename,job,hiredate,sal,comm;

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", mgr=" + mgr +
                ", deptno=" + deptno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", sal='" + sal + '\'' +
                ", comm='" + comm + '\'' +
                '}';
    }


    public Emp() {

    }

    public Emp(int empno, String ename, String job, int mgr, String hiredate, String sal, String comm, int deptno) {
        this.empno = empno;
        this.mgr = mgr;
        this.deptno = deptno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

}
