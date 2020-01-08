package com.syc.china.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 汪梦瑶
 * @create  2020-01-08 14:15
 */
@Data
public class UserDto implements Serializable {

    private String username;

    private String password;

    private boolean rememberMe;  //记住密码

}
