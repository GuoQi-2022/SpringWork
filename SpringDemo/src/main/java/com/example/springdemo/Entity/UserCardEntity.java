package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCardEntity {
    private Long id;

    /**
     * 用户id
     */
    private Long yxUserId;

    /**
     * 卡金额
     */
    private Double cardAmount;

    /**
     * 卡剩余金额
     */
    private Double remainAmount;

    /**
     * 锁定金额
     */
    private Double lockAmount;

    /**
     * 卡回收时间
     */
    private Long endTime;

    /**
     * 卡id
     */
    private Long cardId;

    /**
     * 所属活动id
     */
    private Long actId;

    /**
     * 是否回收
     */
    private Boolean recovery;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 客户号
     */
    private String enterpriseNo;

    private Long createTime;

    private Long updateTime;
}
