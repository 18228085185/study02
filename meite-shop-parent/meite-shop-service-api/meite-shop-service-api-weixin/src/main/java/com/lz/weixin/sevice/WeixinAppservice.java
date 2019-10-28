package com.lz.weixin.sevice;

import com.lz.core.base.BaseResponse;
import com.lz.wei.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lz
 * @create 2019/6/13
 */
@Api(tags = "微信服务接口")
public interface WeixinAppservice {

    /**
     * 应用服务接口
     * @return
     */
    @ApiOperation(value = "调用微信服务接口")
    @GetMapping("/getApp")
    BaseResponse<AppEntity> getApp();

}
