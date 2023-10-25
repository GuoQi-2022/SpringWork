/**
 * @(#)DeliveryExpressCabinetBean.java, 2022/4/2.
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
public class DeliveryExpressCabinetBean {
    /**
     * 自提柜名称
     */
    private String name;

    /**
     * 自提柜地址
     */
    private String address;

    /**
     * 物流公司类型
     */
    private int type;

    /**
     * 状态 0=不在柜中 1=派件入柜，未取 2=超时未取（滞留） 3=快递员取消派件 4=客户已取
     */
    private int status;
}