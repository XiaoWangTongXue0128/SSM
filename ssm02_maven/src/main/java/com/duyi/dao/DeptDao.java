package com.duyi.dao;


import com.duyi.domain.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeptDao {

    @Insert("insert into t_dept values(null,#{dname},#{loc})")
    @Options(useGeneratedKeys = true,keyProperty = "dno")
    void save(Dept dept) ;


    @Select("select * from t_dept")
    @Results({
            @Result(property = "dno" , column = "dno",id = true),
            @Result(property = "dname",column = "dname"),
            @Result(property = "loc",column = "loc"),
            @Result(property = "emps",column = "dno",many = @Many(select="com.com.duyi.dao.EmpDao.findByDept"))
    })
    List<Dept> findAll();
}
