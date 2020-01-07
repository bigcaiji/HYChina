package com.syc.china.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.china.enums.ExceptionEnums;
import com.syc.china.exception.HyException;
import com.syc.china.mapper.GoodsSourceMapper;
import com.syc.china.pojo.GoodsSource;
import com.syc.china.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

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
            goodsSource.setCreateTime(new Date());
            goodsSourceMapper.insert(goodsSource);
        }catch (Exception e){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
    }

    public PageResult<GoodsSource> queryCarSourceByPage(Integer page, Integer rows) {
        PageHelper.startPage(page-1, Math.min(rows, 100));
        List<GoodsSource> list = goodsSourceMapper.selectAll();
        if(CollectionUtils.isEmpty(list)){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
        PageResult<GoodsSource> pages = new PageResult<>();
        PageInfo<GoodsSource> info = new PageInfo<GoodsSource>(list);
        pages.setItems(list);
        pages.setTotal(info.getTotal());
        pages.setTotalPage((long) info.getPages());
        return pages;
    }

    public PageResult<GoodsSource> queryByUserId(Long userId, Integer page, Integer rows) {

        PageHelper.startPage(page-1, Math.min(rows, 100));
        GoodsSource carSource = new GoodsSource();
        carSource.setUserId(userId);
        List<GoodsSource> list = goodsSourceMapper.select(carSource);
        if(CollectionUtils.isEmpty(list)){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
        PageResult<GoodsSource> pages = new PageResult<>();
        PageInfo<GoodsSource> info = new PageInfo<GoodsSource>(list);
        pages.setItems(list);
        pages.setTotal(info.getTotal());
        pages.setTotalPage((long) info.getPages());
        return pages;
    }

    public Boolean updateCarSource(GoodsSource goodsSource) {
            int i = goodsSourceMapper.updateByPrimaryKeySelective(goodsSource);
            if(i!=0){
                return true;
            }
            return false;

        }

    }

