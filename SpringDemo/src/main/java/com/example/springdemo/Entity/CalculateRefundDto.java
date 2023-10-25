/**
 * @(#)CalculateRefundDto.java, 2023/2/1.
 * <p/>
 * Copyright 2023 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author ysl (wb.yeshunliang01@mesg.corp.netease.com)
 */
@Data
public class CalculateRefundDto {
    private BigDecimal discountPrice;
    private BigDecimal discountPriceTrans;
    private BigDecimal itemCashPrice;
    private BigDecimal itemCashPriceTrans;
    private BigDecimal itemWelfarePrice;
    private BigDecimal itemWelfarePriceTrans;
    private Integer saleCount;
    private Integer currentCount;
    private boolean check;
}