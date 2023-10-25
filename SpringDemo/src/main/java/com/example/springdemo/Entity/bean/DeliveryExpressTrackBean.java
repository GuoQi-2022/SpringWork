/**
 * @(#)DeliveryExpressTrackBean.java, 2022/4/2.
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
public class DeliveryExpressTrackBean {
    /**
     * 时间
     */
    private String time;

    /**
     * 描述
     */
    private String desc;

    /**
     * 节点代码
     */
    private String code;

    /**
     * 严选标准节点
     */
    private String yxCode;
}