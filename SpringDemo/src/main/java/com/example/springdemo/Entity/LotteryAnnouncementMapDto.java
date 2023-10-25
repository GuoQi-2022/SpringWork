package com.example.springdemo.Entity;

import lombok.Builder;
import lombok.Data;

/**
 * 中奖公示名单
 * 
 * @author Tmind
 */
@Data
@Builder
public class LotteryAnnouncementMapDto {
    /**
     * 中奖商品名
     */
    private String itemName;

    /**
     * 商品兑换码
     */
    private String cdKey;

}
