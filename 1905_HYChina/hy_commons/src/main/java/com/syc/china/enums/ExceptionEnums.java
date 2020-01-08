package com.syc.china.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExceptionEnums {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),

    UNKNOWN_ERROR(111,"未知错误"),

    REGISTER_CODE_IS_ERROR(601,"验证码为空"),

    ACCOUNT_IS_NOT_EXIST(602,"账户不存在"),

    USERNAME_OR_PASSWORD_ERROR(603,"用户名或密码错误");

    private int code;
    private String msg;
}
