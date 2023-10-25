/**
 * @(#)UserSearch.java, 2022/4/2.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity;

import java.util.List;

import lombok.Data;

/**
 * @author 郭旗(wb.guoqi @ mesg.corp.netease.com)
 */
@Data
public class OrderErrorMsgBean {
    /**
     * 6
     */
    private int code;

    /**
     * 每一个SkuErrorMsgBean对象对应的是无法配送的商品信息
     */
    private List<SkuErrorMsgBean> skuList;
}
