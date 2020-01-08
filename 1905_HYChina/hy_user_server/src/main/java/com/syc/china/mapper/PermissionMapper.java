package com.syc.china.mapper;

import com.syc.china.pojo.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 汪梦瑶
 * @create  2020-01-08 15:23
 */
public interface PermissionMapper extends Mapper<Permission> {



    @Select("SELECT perms FROM hy_permission WHERE permission_id in (SELECT permission_id from hy_role_permission WHERE role_id in(SELECT role_id from hy_user_role WHERE user_id=#{userId}))")
    List<String> findPermissionsByUserId(@Param("userId") Long userId);
}
