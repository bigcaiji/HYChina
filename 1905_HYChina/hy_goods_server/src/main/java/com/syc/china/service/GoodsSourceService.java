package com.syc.china.service;

import com.syc.china.enums.ExceptionEnums;
import com.syc.china.exception.HyException;
import com.syc.china.mapper.GoodsSourceMapper;
import com.syc.china.pojo.GoodsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class GoodsSourceService {
    @Autowired
    private GoodsSourceMapper goodsSourceMapper;

    public GoodsSource queryById(Long id) {
        return goodsSourceMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Long id) {
        try {
            int i = goodsSourceMapper.deleteByPrimaryKey(id);


        }catch (Exception e){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }



    }

    public void insert(GoodsSource goodsSource) {
        try {
            goodsSourceMapper.insert(goodsSource);
        }catch (Exception e){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
    }
}
