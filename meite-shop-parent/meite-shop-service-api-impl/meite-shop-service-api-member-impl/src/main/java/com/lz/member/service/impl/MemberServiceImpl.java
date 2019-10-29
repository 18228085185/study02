package com.lz.member.service.impl;

import com.lz.core.base.BaseApiService;
import com.lz.core.base.BaseResponse;
import com.lz.core.constants.Constant;
import com.lz.core.constants.Constants;
import com.lz.member.entity.UserEntity;
import com.lz.member.feign.WeixinAppserviceFeign;
import com.lz.member.mapper.UserMapper;
import com.lz.member.service.MemberService;
import com.lz.wei.entity.AppEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lz
 * @description :
 * @create : 2019/6/13
 */
@RestController
public class MemberServiceImpl extends BaseApiService<UserEntity> implements MemberService {

    @Autowired
    private WeixinAppserviceFeign weixinAppserviceFeign;
    @Autowired
    private UserMapper userMapper;


    @Override
    public AppEntity memberInvokeWeixin() {
//        return weixinAppserviceFeign.getApp();
        return null;
    }

    @Override
    public BaseResponse<UserEntity> existMobile(String mobile) {
        //1.判断参数
        if(StringUtils.isEmpty(mobile)){
            return setResultError("手机号码不能为空！");
        }
        //2.查询数据库判断手机号码是否存在
        UserEntity userEntity = userMapper.existMobile(mobile);
        if(userEntity == null){
            return setResultError((Integer)Constant.HTTP_RES_CODE_EXISTMOBILE_203.getMess(),"用户不存在");
        }
        //对特殊敏感字段做脱敏  所以要DTO PO转换
        userEntity.setPassword(null);
        //邮箱隐藏几位
        return setResultSuccess(userEntity);
    }
}
