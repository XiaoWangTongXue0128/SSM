package com.duyi.controller;

import com.duyi.domain.Car;
import com.duyi.service.CarService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService service ;

    @RequestMapping("importCars")
    @ResponseBody
    public String importCars(MultipartFile excel) throws IOException {
        InputStream is = excel.getInputStream() ;

        //获得上传的文件内容后，根据业务操作文件内容
        //POI读取excel文件中的数据
        List<Car> cars = new ArrayList<Car>();//准备装载excel文件中的内容

        Workbook book = WorkbookFactory.create(is) ; //excel对象
        Sheet sheet = book.getSheetAt(0); //excel中的一个sheet表对象
        for(int i=1 ;i<=sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);//excel中的行对象
            Cell cell1 = row.getCell(0) ;//excel中的单元对象
            Cell cell2 = row.getCell(1) ;
            Cell cell3 = row.getCell(2) ;

            String cname = cell1.toString() ;
            String color = cell2.toString() ;
            Integer price = Integer.parseInt( cell3.toString().replace(".0","") ) ; //300000.0 -> 300000->int

            Car car = new Car(null,cname,color,price) ;
            cars.add(car) ;
        }

        //从上传的excel文件中，读取了所有的汽车信息，并装入List集合。
        service.saves(cars);

        return "imports success !!!" ;
    }

    @RequestMapping("carList")
    public ModelAndView carList(){
        List<Car> cars = service.findAll() ;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cars.jsp");
        mv.addObject("cars",cars) ;
        return mv ;
    }


    public void save(){

    }

    public void delete(){

    }

}
