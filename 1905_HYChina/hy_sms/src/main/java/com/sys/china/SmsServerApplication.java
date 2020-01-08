package com.sys.china;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 汪梦瑶
 * @create  2020-01-07 16:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SmsServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmsServerApplication.class,args);
    }
}
