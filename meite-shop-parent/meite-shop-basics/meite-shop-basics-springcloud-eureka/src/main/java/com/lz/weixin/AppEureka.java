package com.lz.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : lz
 * @description :
 * @create : 2019/6/13
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka {

    public static void main(String[] args) {
        SpringApplication.run(AppEureka.class, args);
    }
}
