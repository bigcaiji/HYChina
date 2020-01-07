package com.syc.china.controller;

import com.syc.china.enums.ExceptionEnums;
import com.syc.china.exception.HyException;
import com.syc.china.pojo.GoodsSource;
import com.syc.china.service.GoodsSourceService;
import com.syc.china.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *
 */
@RestController
public class GoodsSourceController {
    @Autowired
    private GoodsSourceService goodsSourceService;


    //查询全部货源信息
    @GetMapping("queryall")
    public ResponseEntity<PageResult<GoodsSource>> listAll(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    ){
        PageResult<GoodsSource> pages = goodsSourceService.queryCarSourceByPage(page,rows);
        return ResponseEntity.ok(pages);
    }

    //根据用户id查询全部货源信息
    @GetMapping("/queryByUserId")
    public ResponseEntity<PageResult<GoodsSource>> queryByUserId(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    ){
        PageResult<GoodsSource> pages = goodsSourceService.queryByUserId(userId,page,rows);
        return ResponseEntity.ok(pages);
    }


    //查询单个货源信息
    @GetMapping("/{id}")
    public ResponseEntity<GoodsSource> listOne(@PathVariable("id")Long id){
        if (id == null){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
        GoodsSource goodsSource=goodsSourceService.queryById(id);
        return ResponseEntity.ok(goodsSource);
    }

    //新增货源信息
    @PostMapping("/insert")
    public ResponseEntity<Void> insertOne(@RequestBody GoodsSource goodsSource){

        goodsSourceService.insert(goodsSource);
        return ResponseEntity.ok(null);
    }

    //删除单个货源信息
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteOne(@PathVariable("id")Long id){
        if (id == null){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
        goodsSourceService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //修改货源信息
    @PutMapping("/update")
    public  ResponseEntity<Boolean> updateCarSource(@RequestBody GoodsSource goodsSource){
        Boolean i = goodsSourceService.updateCarSource(goodsSource);
        return  ResponseEntity.ok(i);
    }
}
