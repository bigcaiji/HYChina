package com.sys.china.service;

import com.alibaba.fastjson.JSON;
import com.syc.china.entity.SysLog;
import com.sys.china.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    @Autowired
    private AmqpTemplate template;

    public void transferLog(SysLog sysLog) {
        template.convertAndSend(RabbitMQConfig.QUEUE_NAME, JSON.toJSONString(sysLog));
    }

}
