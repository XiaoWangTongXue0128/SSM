package com.duyi.dao;

import com.duyi.domain.Car;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDao extends SqlSessionDaoSupport {

    @Autowired
    public void setFactory(SqlSessionFactory factory){
        super.setSqlSessionFactory(factory);
    }

    public void save(Car car){
        //原来自己写jdbc
        //现在让mybatis实现jdbc
        //原来自己管理mybatis，自己造工厂，要sqlSession
        //现在让spring注入工厂
        SqlSession session = super.getSqlSession() ;
        session.insert("car.save",car) ;
        // session.commit(); 因为事务也交给spring管理，所以不需要自己提交处理。
    }

    public List<Car> findAll(){
        SqlSession session = super.getSqlSession() ;
        // 什么情况下必须是 this 和 super 关键字
        return session.selectList("car.findAll") ;
    }
}
