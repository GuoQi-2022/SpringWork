package com.example.springdemo.Entity;

import java.util.List;

import lombok.Data;

/**
 * @author Tmind
 */
@Data
public class ChannelCreateRefundDto {

    /**
     * 退单id
     */
    private String applyId;

    /**
     * 商品审核信息
     */
    private List<ChannelCreateSku> skuList;

    /**
     * 业务方标识
     */
    private String productId;

    /**
     * 0-全部拒绝， 1-部分拒绝，2-全部通过
     */
    private Integer auditStatus;

    /**
     * 渠道id
     */
    private String channelId;

}
