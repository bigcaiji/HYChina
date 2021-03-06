package com.syc.china.exception;

import com.syc.china.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HyException extends RuntimeException {
    private ExceptionEnums exceptionEnums;
}
