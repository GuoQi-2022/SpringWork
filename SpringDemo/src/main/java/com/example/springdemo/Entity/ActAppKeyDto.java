package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author Tmind
 */
@Data
public class ActAppKeyDto {
    /**
     * 第三方大客户唯一key
     */
    private String appKey;

    /**
     * 加密key 签名加盐值appSecret，用于加签sign值的生成
     */
    private String appSecret;

    /**
     * 企业号
     */
    private Long channelId;
}
