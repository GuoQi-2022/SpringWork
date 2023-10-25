/**
 * @(#)SkuVO.java, 2021/4/13.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author 丁畅(dingchang @ corp.netease.com)
 */
@Data
public class SkuVO {
    // sku id
    private long id;

    // 是否主sku
    private boolean primarySku;

    // 销售库存
    private int sellVolume;

    // 是否可用
    private boolean valid;

    // 是否预售
    private boolean presell;

    // 预售描述
    private String presellDesc;

    // 限购数量：该SKU该用户当前还可购买数量=账户限购数量-之前购买过的数量；具体含义：小于0-已达限购数量，等于0-不限购，大于0-当前可购买数量；
    // 此处使用等于0表示不限购，是为了规避系统默认值风险，遵循使用系统默认值作为常规状态的规则
    private int limitPurchaseCount = 0;

    /**
     * 正常销售价
     */
    private String retailPriceV2;

    /**
     * 活动价，所有单品变价活动当前可销售的活动价均通过该字段设置，包括：梯度变价，限时购，专享价，特价等
     */
    private String activityPrice;

    /**
     * 无法购买时，操作按钮的文案描述
     */
    private String disableBuyDesc;

    /**
     * sku不可参加任何活动的提示文案描述，非null且非空字符表示sku不可参加；展示在规格面板价格之后
     */
    private String promForbiddenDesc;

    /**
     * sku名称
     */
    private String skuTitle;

    /**
     * 不可购买情况的提示文案 sku维度
     */
    private String versionForbidDesc;
}
