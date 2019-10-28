package com.lz.weixin.service.impl;

import com.lz.core.base.BaseApiService;
import com.lz.core.base.BaseResponse;
import com.lz.wei.entity.AppEntity;
import com.lz.weixin.sevice.WeixinAppservice;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lz
 * @create 2019/6/13
 */
@RestController
public class WeiXinAppServiceImpl extends BaseApiService<AppEntity> implements WeixinAppservice {


    @Override
    public BaseResponse<AppEntity> getApp() {
        AppEntity appEntity = new AppEntity();
        appEntity.setAppId("3737");
        appEntity.setAppName("lz");
        return setResultSuccess(appEntity);
    }


}
