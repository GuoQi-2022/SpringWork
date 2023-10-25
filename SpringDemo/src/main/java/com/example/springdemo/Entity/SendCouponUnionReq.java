package com.example.springdemo.Entity;

import java.util.List;

import lombok.Data;

/**
 * @author Tmind
 */
@Data
public class SendCouponUnionReq {

    /**
     * 优惠券ID
     */
    private Long couponId;

    /**
     * 渠道ID：与工行约定，固定为6901869
     */
    private Long channelId;

    /**
     * 工行用户ID
     */
    private List<String> unionUserIds;

    /**
     * 发放数量
     */
    private int num;

    /**
     * 不存在的用户是否注册新账号
     */
    private Boolean register;

    /**
     * 加密后结果
     */
    private String sign;

}
