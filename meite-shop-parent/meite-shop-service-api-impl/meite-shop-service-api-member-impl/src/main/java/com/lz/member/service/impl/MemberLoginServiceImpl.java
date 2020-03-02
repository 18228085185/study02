package com.lz.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lz.core.base.BaseApiService;
import com.lz.core.base.BaseResponse;
import com.lz.core.constants.Constants;
import com.lz.core.token.GenerateToken;
import com.lz.core.utils.MD5Util;
import com.lz.member.input.dto.UserLoginInpDTO;
import com.lz.member.mapper.UserMapper;
import com.lz.member.mapper.entity.UserDO;
import com.lz.member.service.MemberLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberLoginServiceImpl extends BaseApiService<JSONObject> implements MemberLoginService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GenerateToken generateToken;


    @Override
    public BaseResponse<JSONObject> login(@RequestBody UserLoginInpDTO userLoginInpDTO){
        // 1.验证参数
        String mobile = userLoginInpDTO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        String password = userLoginInpDTO.getPassword();
        if (StringUtils.isEmpty(password)) {
            return setResultError("密码不能为空!");
        }
        String loginType = userLoginInpDTO.getLoginType();
        if (StringUtils.isEmpty(loginType)) {
            return setResultError("登陆类型不能为空!");
        }
        //目的是限制范围
        if (!(loginType.equals(Constants.MEMBER_LOGIN_TYPE_ANDROID) || loginType.equals(Constants.MEMBER_LOGIN_TYPE_IOS)
                || loginType.equals(Constants.MEMBER_LOGIN_TYPE_PC))) {
            return setResultError("登陆类型出现错误!");
        }


        //2.对登录密码进行加密
        String newPassword = MD5Util.MD5(password);

        //3.使用手机号加密码查询数据库，判断用户是否存在
        UserDO userDO = userMapper.login(mobile, newPassword);
        if(userDO == null){
            return setResultError("用户名称或者密码错误！");
        }
        //4.获取userid
        Long userid = userDO.getUserid();
        //5.生成对应用户的令牌放在redis中
        String keyPrefix = Constants.MEMBER_TOKEN_KEYPREFIX + loginType;
        String token = generateToken.createToken(keyPrefix, userid.toString());
        JSONObject data = new JSONObject();
        data.put("token",token);
        return setResultSuccess(data);
    }

}
