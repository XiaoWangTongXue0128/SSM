package com.duyi.service;

import com.duyi.dao.CarDao;
import com.duyi.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarDao dao ;

    public void saves(List<Car> cars){
        for(Car car : cars){
            //存储汽车信息
            dao.save(car);
        }
    }

    public List<Car> findAll(){
        return dao.findAll();
    }
}
