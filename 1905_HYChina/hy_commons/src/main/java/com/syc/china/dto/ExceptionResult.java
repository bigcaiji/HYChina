package com.syc.china.dto;

import com.syc.china.enums.ExceptionEnums;
import lombok.Data;

/**
 *
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timeStamp;

    public ExceptionResult(ExceptionEnums ex){
        this.status=ex.getCode();
        this.message=ex.getMsg();
        this.timeStamp=System.currentTimeMillis();
    }
}
