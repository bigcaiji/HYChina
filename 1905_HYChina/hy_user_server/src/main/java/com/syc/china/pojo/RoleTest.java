package com.syc.china.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.Permissions;
import java.util.Set;

/**
 * @author 汪梦瑶
 * @create  2020-01-08 16:26
 */
@Data
@AllArgsConstructor
public class RoleTest {

    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<PermissionsTest> permissions;
    //省略set、get方法等.....
}