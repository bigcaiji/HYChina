package com.syc.china.mapper;

import com.syc.china.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 汪梦瑶
 * @create  2020-01-08 15:12
 */
public interface RoleMapper extends Mapper<Role> {


    @Select("SELECT role_name FROM hy_role WHERE role_id IN(SELECT role_id FROM hy_user_role WHERE user_id=#{userId})")
    List<String> findRolesByUserId(@Param("userId") Long userId);
}
