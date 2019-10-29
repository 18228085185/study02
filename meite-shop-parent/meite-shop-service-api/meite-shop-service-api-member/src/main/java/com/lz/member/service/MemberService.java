package com.lz.member.service;

import com.lz.core.base.BaseResponse;
import com.lz.member.entity.UserEntity;
import com.lz.wei.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 根据手机号码查询是否已经存在,如果存在返回当前用户信息
     *
     * @param mobile
     * @return
     */
    @ApiOperation(value = "根据手机号码查询是否已经存在")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobile", dataType = "String", required = true, value = "用户手机号码"), })
    @PostMapping("/existMobile")
    BaseResponse<UserEntity> existMobile(@RequestParam("mobile") String mobile);


}
