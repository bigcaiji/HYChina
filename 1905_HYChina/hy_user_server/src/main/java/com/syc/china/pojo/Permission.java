package com.syc.china.pojo;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author 汪梦瑶
 * @create  2020-01-07 21:44
 */
@Data
@Table(name = "hy_role_permission")
public class Permission {

    private Long id;

    private Long roleId;   //角色id

    private Long permissionId;   //权限id


}
