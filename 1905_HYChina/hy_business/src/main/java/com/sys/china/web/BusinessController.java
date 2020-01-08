package com.sys.china.web;

import com.syc.china.annotation.SysLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BusinessController {

    @GetMapping("/show")
    public String showBusiness() {

        log.warn("business=日志信息....");

        return "success";
    }

    /**
     * 展示薪资的同时,还要把该操作过程记录下来.
     * AOP:面向切面+自定义注解
     */
    @SysLogger(value = "查询薪资")
    @GetMapping("/showSalary")
    public String showSalary() {

        return "50000.0元";
    }

}
