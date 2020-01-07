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

    UNKNOWN_ERROR(111,"未知错误");

    private int code;
    private String msg;
}
