package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author Tmind
 */
@Data
public class ChannelCreateSku {

    /**
     * 申请的个数
     */
    private Long count;

    /**
     * 拒绝的个数
     */
    private Long rejectCount;

    /**
     * skuId
     */
    private Long skuId;

}
