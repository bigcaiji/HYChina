package com.syc.china.advice;

import com.syc.china.dto.ExceptionResult;
import com.syc.china.enums.ExceptionEnums;
import com.syc.china.exception.WlkgException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handlerException(WlkgException e){
        ExceptionEnums em=e.getExceptionEnums();
        return ResponseEntity.status(em.getCode()).body(new ExceptionResult(em));
    }



}
