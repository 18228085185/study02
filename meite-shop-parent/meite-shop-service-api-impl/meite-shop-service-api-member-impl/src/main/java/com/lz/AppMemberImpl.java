package com.lz;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : lz
 * @description : 会员服务实现
 * @create : 2019/6/13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
@EnableApolloConfig
@MapperScan(basePackages = "com.lz.member.mapper")
public class AppMemberImpl {

    public static void main(String[] args) {
        SpringApplication.run(AppMemberImpl.class, args);
    }
}
