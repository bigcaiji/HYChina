package com.syc.china.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志信息实体类
 */
@Data
public class SysLog implements Serializable {

    private String methodName;

    private String params;

    private String operation;

    private Date date;

}
