package com.example.springdemo.Entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderSkuDto {

    /**
     * 包裹号
     */
    private String packetId;

    /**
     * 规格名
     */
    private String skuName;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * 商品图
     */
    private String pic;

    /**
     * 商品id
     */
    private Long itemId;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 原价
     */
    private BigDecimal originalPrice;

    /**
     * 活动价
     */
    private BigDecimal actualPrice;

    /**
     * 企业惠
     */
    private BigDecimal discountPrice = BigDecimal.ZERO;

    /**
     * 单个商品满减金额
     */
    private BigDecimal concessions;

    /**
     * 活动id
     */
    private Long actId;

    /**
     * 套餐id
     */
    private Long setmealId;

    /**
     * sku规格
     */
    private String spec;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否支持企业优惠
     */
    private Boolean discount;

    /**
     * 商品现金支付部分
     */
    private Long itemCashPrice;

    /**
     * 商品福点支付部分
     */
    private Long itemWelfarePrice;
}
