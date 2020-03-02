package com.lz.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lz.core.base.BaseApiService;
import com.lz.core.base.BaseResponse;
import com.lz.core.utils.MD5Util;
import com.lz.core.utils.MyBeanUtils;
import com.lz.member.input.dto.UserInpDTO;
import com.lz.member.mapper.UserMapper;
import com.lz.member.mapper.entity.UserDO;
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
public class MemberRegisterServiceImpl extends BaseApiService<JSONObject> implements MemberRegisterService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public BaseResponse<JSONObject> register(@RequestBody UserInpDTO userInpDTO, String registCode){
        //1.参数验证
        String userName = userInpDTO.getUserName();
        if(StringUtils.isEmpty(userName)){
            return setResultError("用户名称不能为空！");
        }
        String mobile = userInpDTO.getMobile();
        if(StringUtils.isEmpty(mobile)){
            return setResultError("手机号码不能为空！");
        }
        String password = userInpDTO.getPassword();
        if(StringUtils.isEmpty(password)){
            return setResultError("密码不能为空！");
        }
        //.......

        //2.验证注册码是否正确

        //3.对用户密码进行加密
        String newPassword = MD5Util.MD5(password);
        userInpDTO.setPassword(newPassword);

        //4.dto转换成do
        UserDO userDO =  MyBeanUtils.dtoToDo(userInpDTO,UserDO.class);

        //5.调用数据库插入数据
        return userMapper.register(userDO) > 0 ? setResultSuccess("注册成功"):setResultError("注册失败");
    }

}
