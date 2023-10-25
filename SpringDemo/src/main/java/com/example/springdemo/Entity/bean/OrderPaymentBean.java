/**
 * @(#)OrderPaymentBean.java, 2022/4/2.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity.bean;

import lombok.Data;

/**
 * @author ysl (wb.yeshunliang01@mesg.corp.netease.com)
 */
@Data
public class OrderPaymentBean {
    /**
     * 支付剩余时间
     */
    private Long remainTime;
    /**
     * 支付方式 1-网易宝,2-微信,3-支付宝
     */
    private Integer payMethod;
    /**
     * // 支付时间
     */
    private Long payTime;

}