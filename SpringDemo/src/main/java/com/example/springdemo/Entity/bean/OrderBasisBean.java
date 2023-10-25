/**
 * @(#)OrderBasisBean.java, 2022/4/2.
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
public class OrderBasisBean {
    // 订单ID
    private long orderId;
    // 用户ID
    private long userId;
    // 用户姓名
    private String realName;
    // 用户手机
    private String userMobile;
    // 订单状态
    private int status;
    // 订单可见状态
    private int visibleStatus;
    // 支付方式
    private String paymethod;
    // 订单创建时间
    private long createTime;
    // 订单地址
//        private AddressUseBean addressUseBean;
}