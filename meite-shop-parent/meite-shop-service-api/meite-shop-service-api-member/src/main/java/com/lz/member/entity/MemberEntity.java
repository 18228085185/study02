package com.lz.member.entity;


import com.lz.wei.entity.AppEntity;

/**
 * @author : lz
 * @description : 会员服务接口
 * @create : 2019/6/13
 */

public interface MemberEntity {

    /**
     * 会员服务调用微信接口
     * @return
     */
    AppEntity memberInvokeWeiXin();

}
