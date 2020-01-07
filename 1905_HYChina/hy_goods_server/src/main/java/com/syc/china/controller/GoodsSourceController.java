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


    /**
     * 分页查询全部.....模糊查询
     */
    @GetMapping("list")
    public ResponseEntity<PageResult<GoodsSource>> listAll(){


        return ResponseEntity.ok().build();
    }


    /**
     * 查询单个
     */
    @GetMapping("/{id}")
    public ResponseEntity<GoodsSource> listOne(@PathVariable("id")Long id){
        if (id == null){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
        GoodsSource goodsSource=goodsSourceService.queryById(id);
        return ResponseEntity.ok(goodsSource);
    }

    /**
     * 删除单个
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteOne(@PathVariable("id")Long id){
        if (id == null){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
        goodsSourceService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    /**
     * 新增
     */
    @PostMapping("/insert")
    public ResponseEntity<Void> insertOne(@RequestBody GoodsSource goodsSource){

        goodsSourceService.insert(goodsSource);
        return ResponseEntity.ok(null);
    }


}
