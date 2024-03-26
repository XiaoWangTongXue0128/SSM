package com.duyi.service;



import com.duyi.dao.DeptDao;
import com.duyi.dao.EmpDao;
import com.duyi.domain.Dept;
import com.duyi.domain.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wang
 */
@Service
public class DeptService {

    @Autowired
    private DeptDao deptDao ;
    @Autowired
    private EmpDao empDao ;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void save(String dname,String loc , String[] ename , Integer[] sal){
        Dept dept = new Dept(null,dname,loc,null);
        //保存dept，同时获得自增的主键。
        deptDao.save(dept);//保存前dept对象中的dno=null，保存后，dno=具体数值

        for(int i=0;i<ename.length;i++){

            Emp emp = new Emp(null,ename[i],sal[i],dept.getDno(),null);
            empDao.save(emp);
        }
    }


    public List<Dept> findAll(){
        return deptDao.findAll();
    }
}
