/**
 * @(#)OrderResourceBean.java, 2022/4/2.
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
public class OrderResourceBean {
    // 福利商城价格扩展明细
    // 见福礼商城架构升级-正向交易链路改造
    // 2.下单 -> 3.数据模型 -> 1.订单维度 -> 福礼业务信息
    private WelfareOrderExtBean welfareOrderExtBean;
}