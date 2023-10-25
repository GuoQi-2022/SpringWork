package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author wb.guoqi@mesg.corp.netease.com 福点扣减请求体
 */
@Data
public class ReduceNoOrderReq {
    /**
     * 用户id
     */
    private Long uid;

    /**
     * 唯一key
     */
    private String appKey;

    /**
     * 描述
     */
    private String description;

    /**
     * 参与活动单号（抽奖记录id）
     */
    private String orderNum;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 幂等token appkey+uid+orderNum+timestamp+appSecret的md5签名
     */
    private String sign;

    /**
     * 福点数量
     */
    private Double points;

    /**
     * 福点数量
     */
    private Double value;
}
