package com.duyi.dao;


import com.duyi.domain.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpDao {

    @Insert("insert into t_emp values(null,#{ename},#{sal},#{dno})")
    void save(Emp emp);

    @Select("select * from t_emp where dno = #{dno}")
    List<Emp> findByDept(Integer dno) ;

}
