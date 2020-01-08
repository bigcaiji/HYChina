package com.sys.china.aop;

import com.alibaba.fastjson.JSON;
import com.syc.china.annotation.SysLogger;
import com.syc.china.entity.SysLog;
import com.sys.china.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 使得当前类成为一个切面类
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private LoggerService loggerService;

    //@Pointcut("execution(* com.syc.china.web.*.*)")
    @Pointcut("@annotation(com.syc.china.annotation.SysLogger)")
    public void pointCut() {
    }

    /**
     * JoinPoint:获取目标类的相关信息
     */
    @Before("pointCut()")
    public void recordLog(JoinPoint point) {
        //获取类的方法签名信息
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        //封装操作的日志信息
        SysLog sysLog = new SysLog();
        //获取目标类,com.syc.china.web.BusinessController
        String className = point.getTarget().getClass().getName();
        //showSalary()
        String methodName = signature.getName();
        sysLog.setMethodName(className + "." + methodName);

        Object[] args = point.getArgs();
        String params = "";
        for (Object arg : args) {
            params += JSON.toJSONString(arg);
        }
        if (!StringUtils.isEmpty(params)) {
            sysLog.setParams(params);
        }

        SysLogger annotation = method.getAnnotation(SysLogger.class);
        if (annotation != null) {
            String operation = annotation.value();
            sysLog.setOperation(operation);
        }

        sysLog.setDate(new Date());

        //传输日志信息
        loggerService.transferLog(sysLog);
    }

}
