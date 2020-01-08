package com.syc.china.service;

import com.syc.china.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 汪梦瑶
 * @create  2020-01-08 15:10
 */
@Service
public class RoleService {


    @Autowired
    private RoleMapper roleMapper;


    /**
     * 通过用户id查询对应的角色
     * @param userId
     * @return
     */
    public List<String> findRolesByUserId(Long userId){
        return roleMapper.findRolesByUserId(userId);
    }
}
