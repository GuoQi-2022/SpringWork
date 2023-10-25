package com.example.springdemo.Entity;

import lombok.Data;

/**
 * 满减活动类型及id
 * 
 * @author wb.guoqi@mesg.corp.netease.com
 */
@Data
public class SetmealSkuInfo {

    /**
     * 套餐id
     */
    private Long setmealId;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 商品数量
     */
    private Integer num;

}
