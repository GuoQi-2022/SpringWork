package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author Tmind
 */
@Data
public class OkLifeLoginReq {
    /**
     * 联登方明文标识，提供给需要联登的第三方，用于区分身份
     */
    private String from;

    /**
     * 手机号
     */
    private Long mobile;

    /**
     * 请求时间,请求时间，时间戳，秒级
     */
    private Long timestamp;

    /**
     * 安付宝用户id
     */
    private String uid;

    /**
     * 加签
     */
    private String sign;

    /**
     * 跳转活动链接url，或者由第三方自己定义的标识串，用于单点登录后跳转活动页面的标识
     */
    private String jumpUrl;

}
