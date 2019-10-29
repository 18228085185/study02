package com.lz.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lz.core.base.BaseApiService;
import com.lz.core.base.BaseResponse;
import com.lz.core.utils.MD5Util;
import com.lz.member.entity.UserEntity;
import com.lz.member.mapper.UserMapper;
import com.lz.member.service.MemberRegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lz
 * @description :
 * @create : 2019/10/29
 */
@RestController
public class MemberRegisterServiceImpl extends BaseApiService<UserEntity> implements MemberRegisterService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public BaseResponse<UserEntity> register(@RequestBody UserEntity userEntity, String registCode){
        //1.参数验证
        String userName = userEntity.getUserName();
        if(StringUtils.isEmpty(userName)){
            return setResultError("用户名称不能为空！");
        }
        String mobile = userEntity.getMobile();
        if(StringUtils.isEmpty(mobile)){
            return setResultError("手机号码不能为空！");
        }
        String password = userEntity.getPassword();
        if(StringUtils.isEmpty(password)){
            return setResultError("密码不能为空！");
        }
        //.......

        //2.验证注册码是否正确

        //3.对用户密码进行加密
        String newPassword = MD5Util.MD5(password);
        userEntity.setPassword(newPassword);
        //4.调用数据库插入数据
        return userMapper.register(userEntity) > 0 ? setResultSuccess("注册成功"):setResultError("注册失败");
    }

}
