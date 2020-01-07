package com.syc.china;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableAdminServer
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MonitorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorAdminApplication.class, args);
    }

}
