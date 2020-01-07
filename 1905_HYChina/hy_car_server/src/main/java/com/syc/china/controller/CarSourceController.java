package com.syc.china.controller;

import com.github.pagehelper.Page;
import com.sun.org.apache.regexp.internal.RE;
import com.syc.china.enums.ExceptionEnums;
import com.syc.china.exception.HyException;
import com.syc.china.pojo.CarSource;
import com.syc.china.service.CarSourceService;
import com.syc.china.vo.PageResult;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * @author 王聪
 * @company 上海千锋
 * @create  2020-01-07 16:19
 */
@RestController
public class CarSourceController {

    @Autowired
    private CarSourceService carSourceService;

    //分页查询全部车源信息
    @GetMapping("/queryall")
    public ResponseEntity<PageResult<CarSource>> queryCarSourceBypage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    ){
        PageResult<CarSource> pages = carSourceService.queryCarSourceByPage(page,rows);
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/queryByUserId")
    public ResponseEntity<PageResult<CarSource>> queryByUserId(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    ){
        PageResult<CarSource> pages = carSourceService.queryByUserId(userId,page,rows);
        return ResponseEntity.ok(pages);
    }


    //根据id查询单个车源信息
    @GetMapping("/{id}")
    public ResponseEntity<CarSource> queryCarSourceById(@PathVariable("id")Long id){
        if (id==null){
            throw new HyException(ExceptionEnums.PRICE_CANNOT_BE_NULL);
        }
        CarSource carSource = carSourceService.queryCarSourceById(id);

        return  ResponseEntity.ok(carSource);
    };

    //发布车源信息
    @PostMapping("/insert")
    public ResponseEntity<Void> addCarSource(@RequestBody CarSource carSource){
        carSourceService.addCarSource(carSource);
        return ResponseEntity.ok(null);
    }

    //删除车源信息
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCarSource(@PathVariable("id")Long id){
        Boolean i = carSourceService.deleteCarSource(id);
        return ResponseEntity.ok(i);
    }


    //修改车源信息
    @PutMapping("/update")
    public  ResponseEntity<Boolean> updateCarSource(@RequestBody CarSource carSource){
        Boolean i = carSourceService.updateCarSource(carSource);
        return  ResponseEntity.ok(i);
    }
}
