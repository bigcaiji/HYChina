package com.sys.china.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 汪梦瑶
 * @create  2020-01-07 17:06
 */
@Data
@ConfigurationProperties(prefix = "hychina.sms")
public class SmsProperties {

    String accessKeyId;

    String accessKeySecret;

    String signName;

    String verifyCodeTemplate;
}
