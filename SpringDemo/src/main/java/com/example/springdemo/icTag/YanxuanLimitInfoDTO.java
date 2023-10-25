package com.example.springdemo.icTag;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tmind
 */
@Data
@Builder
public class YanxuanLimitInfoDTO {

    /**
     * 业务Id
     */
    private Long businessId;

    /**
     * 业务key
     */
    private String businessKey;

    /**
     * 渠道id
     */
    private String channelId;

    /**
     * 当前周期已购数目
     */
    private Integer historyCount;

    /**
     *
     */
    private Boolean historyCountDowngrade;

    /**
     * 商品id
     */
    private String itemId;

    /**
     * 当前周期限购数目
     */
    private Integer limitNum;

    /**
     * 限购规则id
     */
    private Long limitPurchaseId;

    /**
     * 限购规则类型 12
     */
    private Long limitPurchaseType;

    /**
     *
     */
    private Object periodInfo;

    /**
     * skuId
     */
    private Long skuId;

}
