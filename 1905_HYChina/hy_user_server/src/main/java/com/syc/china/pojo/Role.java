package com.syc.china.pojo;

import lombok.Data;

import javax.persistence.Table;
import java.util.Set;

/**
 * @author 汪梦瑶
 * @create  2020-01-07 21:40
 */
@Data
@Table(name = "hy_user_role")
public class Role {
    private Long id;
    private Long userId;   //用户id
    private Long roleId;  //角色id

    private Set<Permission> permissions;  //角色对应的权限集合
}
