package com.syc.china.rabbit;

import com.alibaba.fastjson.JSON;
import com.syc.china.entity.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收消息
 */
@Component
@Slf4j
public class ReceiveMsg {

    //@RabbitListener("china_log_name")

    public void receiveMsg(String json) {
        //把json字符串变成对应的对象
        SysLog sysLog = JSON.parseObject(json, SysLog.class);

        //TODO:可以把该对象存储到数据库...

        //把该信息自动传输到elk环境中
        log.warn("msg=" + sysLog);
    }

}
