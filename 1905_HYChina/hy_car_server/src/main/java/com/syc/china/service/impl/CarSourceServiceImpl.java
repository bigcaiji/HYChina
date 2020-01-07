package com.syc.china.service.impl;

import ch.qos.logback.classic.turbo.TurboFilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.china.enums.ExceptionEnums;
import com.syc.china.exception.HyException;
import com.syc.china.mapper.CarSourceMapper;
import com.syc.china.pojo.CarSource;
import com.syc.china.service.CarSourceService;
import com.syc.china.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author 王聪
 * @company 上海千锋
 * @create  2020-01-07 16:21
 */
@Service
public class CarSourceServiceImpl implements CarSourceService {

    @Autowired
    private CarSourceMapper carSourceMapper;

    @Override
    public PageResult<CarSource> queryCarSourceByPage(Integer page, Integer rows) {
        PageHelper.startPage(page-1, Math.min(rows, 100));
        List<CarSource> list = carSourceMapper.selectAll();
        if(CollectionUtils.isEmpty(list)){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
        PageResult<CarSource> pages = new PageResult<>();
        PageInfo<CarSource> info = new PageInfo<CarSource>(list);
        pages.setItems(list);
        pages.setTotal(info.getTotal());
        pages.setTotalPage((long) info.getPages());
        return pages;
    }

    @Override
    public PageResult<CarSource> queryByUserId(Long userId, Integer page, Integer rows) {

        PageHelper.startPage(page-1, Math.min(rows, 100));
        CarSource carSource = new CarSource();
        carSource.setUserId(userId);
        List<CarSource> list = carSourceMapper.select(carSource);
        if(CollectionUtils.isEmpty(list)){
            throw new HyException(ExceptionEnums.UNKNOWN_ERROR);
        }
        PageResult<CarSource> pages = new PageResult<>();
        PageInfo<CarSource> info = new PageInfo<CarSource>(list);
        pages.setItems(list);
        pages.setTotal(info.getTotal());
        pages.setTotalPage((long) info.getPages());
        return pages;
    }

    @Override
    public CarSource queryCarSourceById(Long id) {
        CarSource carSource = carSourceMapper.selectByPrimaryKey(id);
        return  carSource;
    }

    @Override
    public void addCarSource(CarSource carSource) {
        carSource.setCreateTime(new Date());
       carSourceMapper.insertSelective(carSource);

    }

    @Override
    public Boolean updateCarSource(CarSource carSource) {
        int i = carSourceMapper.updateByPrimaryKeySelective(carSource);
        if(i!=0){
            return true;
        }
        return false;

    }



    @Override
    public Boolean deleteCarSource(Long id) {
        int i = carSourceMapper.deleteByPrimaryKey(id);
        if(i!=0){
            return true;
        }
        return false;
    }


}
