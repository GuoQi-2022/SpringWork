package com.example.springdemo.Entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 满减活动类型及id
 *
 * @author Tmind
 */
@Data
public class SkuPromotionInfoDTO {

    private long skuId;

    private int count;

    /**
     * 优惠的金额
     */
    private BigDecimal minusPrice;

    /**
     * 活动id
     */
    private Long promotionId;

    /**
     * 活动类型 PromotionTypeEnum
     *  满减 1
     *  直降价 2
     *  企业优惠 3
     */
    private int promotionType;

    /**
     * 优惠名称 PromotionTypeEnum
     */
    private String promotionName;

    /**
     * 折扣
     */
    private Integer discount;
}
