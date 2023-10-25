package com.example.springdemo.Entity;

import lombok.Data;

@Data
public class LoginReq {
    /**
     * 悠福网用户id
     */
    private String userId;

    /**
     * 加签
     */
    private String sign;

    /**
     * 加签类型,加签类型固定 MD5
     */
    private String signType;

    /**
     * 字符类型,字符类型固定 UTF8
     */
    private String charset;

    /**
     * 请求时间,请求时间，时间戳，秒级
     */
    private Long timestamp;

    /**
     * 联登方明文标识，提供给需要联登的第三方，用于区分身份
     */
    private String unionLogo;

}
