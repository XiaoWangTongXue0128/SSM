package com.duyi.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Component
public class Dept implements Serializable {
    private Integer dno ;
    private String dname ;
    private String loc ;

    private List<Emp> emps ;

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Dept(Integer dno, String dname, String loc, List<Emp> emps) {
        this.dno = dno;
        this.dname = dname;
        this.loc = loc;
        this.emps = emps;
    }

    public Dept() {
    }
}
