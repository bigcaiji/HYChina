package com.syc.china.service;

import com.syc.china.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 汪梦瑶
 * @create  2020-01-08 15:22
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;



    public List<String> findPermissionsByUserId(Long userId){

        return permissionMapper.findPermissionsByUserId(userId);

    }
}
