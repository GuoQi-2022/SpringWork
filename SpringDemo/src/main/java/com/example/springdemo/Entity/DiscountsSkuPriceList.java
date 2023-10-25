package com.example.springdemo.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscountsSkuPriceList {
    /**
     * 套餐id
     */
    private Long setmealId;
    /**
     * 活动id
     */
    private Long actId;
    /**
     * SKUID
     */
    private Long    skuId;
    /**
     * 原价
     */
    private Long    retailPrice;
    /**
     * 优惠后的单品价格
     */
    private Long    discountsPrice;
    /**
     * 兑换数量
     */
    private Integer num;
}
