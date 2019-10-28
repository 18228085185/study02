package com.lz;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
*@description : 微信接口实现启动类
*@author : lz
*@date : 2019/6/13
*
*/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
@EnableApolloConfig
public class AppWeiXinImpl {

	public static void main(String[] args) {
		SpringApplication.run(AppWeiXinImpl.class, args);
	}

}