package com.example.springdemo.Entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopCustomerEntity {
    /**
     * 账户id
     */
    private Long id;

    /**
     * 企业id
     */
    private Long customerId;

    /**
     * 账户名称
     */
    private String customerName;

    /**
     * 企业名称
     */
    private String company;

    /**
     * 运营负责人
     */
    private String operator;

    /**
     * 账户状态
     */
    @Deprecated
    private Integer status;

    /**
     * 合作模式（0 集采 1  联合登陆 2 弹性福利）
     */
    private Integer unionType;

    /**
     * 福礼合作模式(客户标识 0 S类 1 A类 2 B类 3 C类 4 D类)
     */
    private Integer unionTag;

    /**
     * 混合支付 0不支持，1支持
     */
    private Integer mixedPay;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 福礼商城名称
     */
    private String  shopName;

    /**
     * 价格单位
     */
    private String priceUnit;

    /**
     * 兑换比例
     */
    private Double ratio;

    /**
     * 分销绑定渠道
     */
    private Long bindChannel;

    /**
     * 福礼商城logo
     */
    private String shopLogo;

    /**
     * 联登渠道授权logo
     */
    private String authorizationLogo;

    /**
     * 商城首页服务提示
     */
    private String tips;

    /**
     * 创建时间
     */
    private  Long createTime;

    /**
     * 更新时间
     */
    private  Long updateTime;

    /**
     * appKey
     */
    private  String appKey;

    /**
     * App标识
     */
    private  String appSecret;

    /**
     * 商品池id
     */
    private Long itemPoolId;

    /**
     * 卡券折扣,88代表88%
     */
    private Integer cardDiscount;

    /**
     * 企业banner样式。0：高版 1：矮版
     */
    private Integer bannerStyle;

    /**
     * 企业活动样式。0：1行2，1：1行3
     */
    private Integer actStyle;

    /**
     * 比价结果(1：异常，2：正常) ComparisonResultsEnum
     */
    private Integer comparisonResults;

    /**
     * 活动让利,88代表88%
     */
    private BigDecimal surrenderProfitsAct;

}
