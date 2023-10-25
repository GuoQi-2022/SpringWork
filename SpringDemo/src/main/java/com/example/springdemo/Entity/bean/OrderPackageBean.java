/**
 * @(#)OrderPackageBean.java, 2022/4/2.
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
public class OrderPackageBean {
    // 包裹ID
    private long id;
    // 包裹状态
    private String status;
    // 订单状态
    private String orderStatus;
    // 包裹确认收货时间
    private long confirmTime;
    // 发货仓库id
    private long storeHouseId;
    // 发货仓库名称
    private String storeHouseName;
    // 订单包裹物流(见[包裹物流查询]一节)
    private List<DeliveryExpressTrackResultBean> deliveryExpressTraceList;
    // 包裹内sku列表
    private List<OrderSkuBean> skuBeanList;
}