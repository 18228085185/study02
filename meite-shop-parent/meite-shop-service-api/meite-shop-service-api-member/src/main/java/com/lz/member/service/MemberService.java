package com.lz.member.service;

import com.lz.wei.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
*@description : 会员服务接口
*@author : lz
*@date : 2019/6/13
*
*/
@Api(tags = "会员服务接口")
public interface MemberService {


    @ApiOperation("会员服务调用微信服务")
    @GetMapping("/memberInvokeWeixin")
    AppEntity memberInvokeWeixin();


}
