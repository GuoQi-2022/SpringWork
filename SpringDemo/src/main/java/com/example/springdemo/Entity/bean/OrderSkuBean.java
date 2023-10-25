/**
 * @(#)OrderSkuBean.java, 2022/4/2.
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
public class OrderSkuBean {
    // SkuId
    private long skuId;
    // 订单Id
    private long orderId;
    // 包裹Id
    private long packageId;
    // 数量
    private int count;
    // 零售价
    private BigDecimal originalPrice;
    // 实付价
    private BigDecimal subTotalPrice;
    // 福礼SKU维度扩展信息
    private WelfareSkuExtBean welfareSkuExtBean;
    // 邮费政策
    private String freightPolicy;
    // 商品id
    private long itemId;
    // Sku图地址
    private String picUrl;
    // SkuName
    private String skuName;
    // Sku描述信息
    private String skuDesc;
    // Sku规格值列表
    private List<String> specValueList;
}