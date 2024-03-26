package com.duyi.controller;


import com.duyi.domain.Dept;
import com.duyi.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService service;

    @RequestMapping(value="saveDept",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String saveDept(String dname , String loc , String[] ename , Integer[] sal){
        System.out.println( dname+","+loc );
        System.out.println( Arrays.toString(ename) );
        System.out.println( Arrays.toString(sal) );

        service.save(dname,loc,ename,sal);

        return "保存成功" ;

    }

    @RequestMapping("deptList")
    @ResponseBody
    public List<Dept> deptList(){
        return service.findAll() ; //springmvc框架的底层，会使用jackson这个json工具转换集合
    }

}
