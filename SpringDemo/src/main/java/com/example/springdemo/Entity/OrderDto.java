package com.example.springdemo.Entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class OrderDto {

    private String orderNo;

    private Integer orderState;

    private Long payTime;

    private Integer payType;

    private BigDecimal orderPrice;

    private BigDecimal itemPrice;

    private BigDecimal discountPrice;

    /**
     * 活动id
     */
    private Long promotionActId;

    /**
     * 渠道满减活动类型（0：全场活动，1：专属活动）
     */
    private Integer promotionActType;

    /**
     * 渠道满减活动优惠金额
     */
    private Long promotionActConcessions;

    private BigDecimal realItemPrice;

    private String yxUid;

    private String userName;

    private String mobile;

    private Long createTime;

    private Long expireTime;

    private String fullAddress;

    private List<OrderSkuDto> orderSkuInfo;

    /**
     * 订单商品现金支付金额
     */
    private Long orderItemCashPrice;

    /**
     * 订单商品福点支付金额
     */
    private Long orderItemWelfarePrice;

    /**
     * 订单邮费现金支付部分
     */
    private Long logisticsCashPrice;

    /**
     * 订单邮费福点支付部分
     */
    private Long logisticsWelfarePrice;

    /**
     * 订单支付使用的总福粒点数
     */
    private Double welfareNum;

    /**
     * 0是普通订单；1是广告位套餐订单
     */
    private Integer isSetmeal;

    /**
     * 鲁商通A卡使用金额（分）
     */
    private Long aPayAmount;

    /**
     * 鲁商通银豆数量(个，无小数位)
     */
    private Long integralPayAmount;

    /**
     * 支付链接
     */
    private String payUrl;

    /**
     * 是否为新架构生成的订单(0 老架构，1 新架构)
     */
    private Boolean newArchitecture;

}
