package com.lz.weixin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lz.core.base.BaseApiService;
import com.lz.core.base.BaseResponse;
import com.lz.core.constants.Constants;
import com.lz.core.utils.RedisUtil;
import com.lz.weixin.sevice.VerificaCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : lz
 * @description :
 * @create : 2019/6/25
 */
public class VerificaCodeServiceImpl extends BaseApiService<JSONObject> implements VerificaCodeService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public BaseResponse<JSONObject> verificaWeixinCode(String phone, String weixinCode) {
        //1.验证码参数是否为空
        if(StringUtils.isEmpty(phone)){
            return setResultError("手机号码不能为空！");
        }
        if(StringUtils.isEmpty(phone)){
            return setResultError("注册码不能为空！");
        }
        //2.根据手机号码查询redis返回值
        String weixinCodeKey = Constants.WEIXINCODE_KEY + phone;
        String redisCode = redisUtil.getString(weixinCodeKey);
        if(StringUtils.isEmpty(weixinCode)){
            return setResultError("验证码可能已经过期！");
        }
        //3.redis中的注册码与传递参数的weixincode进行对比
        if(!weixinCode.equals(redisCode)){
            return setResultError("注册码不正确！");
        }
        //4.移除验证码
        redisUtil.delKey(weixinCodeKey);
        return setResultSuccess("验证码比对正确！");
    }
}
