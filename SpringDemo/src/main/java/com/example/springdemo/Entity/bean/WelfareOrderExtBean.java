/**
 * @(#)WelfareOrderExtBean.java, 2022/4/2.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity.bean;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author ysl (wb.yeshunliang01@mesg.corp.netease.com)
 */
@Data
public class WelfareOrderExtBean {
    private Long channelId;
    //活动满减id
    private Long promotionActId;
    /**
     * 运费现金
     */
    private Double logisticsCashPrice;
    /**
     * 运费福利
     */
    private BigDecimal logisticsWelfarePrice;
    /**
     * 运费实付福利
     */
    private Double logisticsWelfareNum;
    /**
     * 兑换比例
     */
    private Double moneyRate;
    //企业折扣优惠金额
    private BigDecimal corpCoupon;
    //满减优惠金额
    private BigDecimal promotionActConcessions;
    //福粒支付比例
    private Double payRate;
    //企业折扣
    private Double enterpriseDiscount;
}