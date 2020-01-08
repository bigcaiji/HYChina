package com.syc.china.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author 汪梦瑶
 * @create  2020-01-08 16:28
 */
@Data
@AllArgsConstructor
public class UserTest {
    private String id;
    private String userName;
    private String password;
    /**
     * 用户对应的角色集合
     */
    private Set<RoleTest> roles;
    //省略set、get方法等.....
}
