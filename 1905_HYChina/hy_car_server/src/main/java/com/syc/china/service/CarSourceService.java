package com.syc.china.service;

import com.syc.china.pojo.CarSource;
import com.syc.china.service.impl.CarSourceServiceImpl;
import com.syc.china.vo.PageResult;

/**
 * @author 王聪
 * @company 上海千锋
 * @create  2020-01-07 16:20
 */
public interface CarSourceService  {


    PageResult<CarSource> queryCarSourceByPage(Integer page, Integer rows);

    CarSource queryCarSourceById(Long id);

    Boolean deleteCarSource(Long id);

    void addCarSource(CarSource carSource);

    Boolean updateCarSource(CarSource carSource);

    PageResult<CarSource> queryByUserId(Long userId, Integer page, Integer rows);
}
