package com.syc.china.service;

import com.syc.china.pojo.CarSource;
import com.syc.china.service.impl.CarSourceServiceImpl;

/**
 * @author 王聪
 * @company 上海千锋
 * @create  2020-01-07 16:20
 */
public interface CarSourceService  {


    void queryCarSourceBypage(Integer page, Integer rows);

    CarSource queryCarSourceById(Long id);

    Boolean deleteCarSource(Long id);

    void addCarSource(CarSource carSource);
}
