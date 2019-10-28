package com.lz.member.feign;

import com.lz.weixin.sevice.WeixinAppservice;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : lz
 * @description :
 * @create : 2019/6/13
 */
@FeignClient(name = "app-mayikt-weixin")
public interface WeixinAppserviceFeign extends WeixinAppservice {


}
