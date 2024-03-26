package com.duyi.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class Emp implements Serializable {
    /*基本属性*/
    private Integer eno ;
    private String ename ;
    private Integer sal ;
    private Integer dno ;

    /*关联属性(查询时使用)*/
    private Dept dept ; //一个员工有一个所属的部门信息

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp(Integer eno, String ename, Integer sal, Integer dno, Dept dept) {
        this.eno = eno;
        this.ename = ename;
        this.sal = sal;
        this.dno = dno;
        this.dept = dept;
    }

    public Emp() {
    }
}
