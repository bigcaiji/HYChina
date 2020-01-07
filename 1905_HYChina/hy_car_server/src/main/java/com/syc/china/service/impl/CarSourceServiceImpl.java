package com.syc.china.service.impl;

import ch.qos.logback.classic.turbo.TurboFilter;
import com.github.pagehelper.PageHelper;
import com.syc.china.mapper.CarSourceMapper;
import com.syc.china.pojo.CarSource;
import com.syc.china.service.CarSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    public void queryCarSourceBypage(Integer page, Integer rows) {
        PageHelper.startPage(page, Math.min(rows, 100));

        Example example = new Example(CarSource.class);
    }

    @Override
    public CarSource queryCarSourceById(Long id) {
        CarSource carSource = carSourceMapper.selectByPrimaryKey(id);
        return  carSource;
    }

    @Override
    public void addCarSource(CarSource carSource) {
       carSourceMapper.insertSelective(carSource);

    }

    @Override
    public Boolean deleteCarSource(Long id) {
        int i = carSourceMapper.deleteByPrimaryKey(id);
        if(i>0){
            return true;
        }
        return null;
    }


}
