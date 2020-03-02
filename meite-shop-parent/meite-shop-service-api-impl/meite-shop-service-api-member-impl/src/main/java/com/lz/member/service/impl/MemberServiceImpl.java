package com.lz.member.service.impl;

import com.lz.core.base.BaseApiService;
import com.lz.core.base.BaseResponse;
import com.lz.core.constants.Constants;
import com.lz.core.utils.MyBeanUtils;
import com.lz.member.mapper.UserMapper;
import com.lz.member.mapper.entity.UserDO;
import com.lz.member.output.dto.UserOutDTO;
import com.lz.member.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lz
 * @description :
 * @create : 2019/6/13
 */
@RestController
public class MemberServiceImpl extends BaseApiService<UserOutDTO> implements MemberService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResponse<UserOutDTO> existMobile(String mobile) {
        //1.判断参数
        if(StringUtils.isEmpty(mobile)){
            return setResultError("手机号码不能为空！");
        }
        //2.查询数据库判断手机号码是否存在
        UserDO userDO = userMapper.existMobile(mobile);

        if(userDO == null){
            return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203,"用户不存在");
        }
        //do转DTO
        UserOutDTO userOutDTO = MyBeanUtils.doToDto(userDO, UserOutDTO.class);
        return setResultSuccess(userOutDTO);
    }
}
