package com.lz.member.service.impl;

import com.lz.member.feign.WeixinAppserviceFeign;
import com.lz.member.service.MemberService;
import com.lz.wei.entity.AppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lz
 * @description :
 * @create : 2019/6/13
 */
@RestController
public class MemberServiceImpl implements MemberService {

    @Autowired
    private WeixinAppserviceFeign weixinAppserviceFeign;


    @Override
    public AppEntity memberInvokeWeixin() {
        return weixinAppserviceFeign.getApp();
    }
}
