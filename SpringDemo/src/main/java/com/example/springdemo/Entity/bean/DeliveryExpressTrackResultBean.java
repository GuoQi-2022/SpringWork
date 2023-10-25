/**
 * @(#)DeliveryExpressTrackResultBean.java, 2022/4/2.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity.bean;

import java.util.List;

import lombok.Data;

/**
 * @author ysl (wb.yeshunliang01@mesg.corp.netease.com)
 */
@Data
public class DeliveryExpressTrackResultBean {
    /**
     * 物流公司名称，isHasSub=false 情况存在
     */
    private String company;

    /**
     * 物流单号，isHasSub=false 情况存在
     */
    private String number;

    /**
     * 物流公司code，isHasSub=false 情况存在
     */
    private String companyCode;

    /**
     * 是否有子单号，isHasSub=false 情况存在
     */
    private boolean isHasSub;

    /**
     * 子单物流数据 isHasSub=true 情况下存在值
     */
    private List<DeliveryExpressTrackResultBean> subContents;

    /**
     * 物流轨迹数据，isHasSub=false 情况存在
     */
    private List<DeliveryExpressTrackBean> content;

}