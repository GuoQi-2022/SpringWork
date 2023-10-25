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
public class SkuErrorMsgBean {
    /**
     * 是否是加价购商品，true表示是
     */
    private boolean addBuy;

    /**
     * 数量
     */
    private int count;

    /**
     * 不支持配送
     */
    private String errTypeDesc;

    /**
     * 错误提示描述
     */
    private Boolean gift;

    /**
     * 最大购买数量(剩余库存)
     */
    private int maxCount;

    /**
     * 商品名
     */
    private String name;

    /**
     * 年购套餐期数
     */
    private int phaseNum;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 来源id(区分不同活动的相同赠品)
     */
    private int source;

    /**
     * 规格值列表：如果提示的是商品维度，比如商品限购超限，该字段没有值
     */
    private List<String> specValueList;

    /**
     * 优惠措施类型，详见《优惠措施类型》 ，-1或者无法识别的类型需要解析成不属于任何优惠措施
     */
    private int type;

}
