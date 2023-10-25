/**
 * @(#)WelfareSkuExtBean.java, 2022/4/2.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity.bean;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * @author ysl (wb.yeshunliang01@mesg.corp.netease.com)
 */
@Data
public class WelfareSkuExtBean {
    //商品id
    private Long commodityId;
    private BigDecimal orderItemCashPrice;
    private BigDecimal orderItemWelfarePrice;
    private Double welfareNum;
    //福粒批次号
    private List<String> batchNumbers;
    //结算折扣
    private Double settlementDiscount;
    //商品折扣
    private Double discount;
    //礼包标识
    private Boolean giftbag;
    //商城折扣
    private BigDecimal corpCoupon;
    //sku级别满减优惠金额(该sku小计)
    private BigDecimal concessionsPrice;
    //锁定库存key
    private String stockLockKey;
    //共享库存数量
    private Long shareStockNum;
}