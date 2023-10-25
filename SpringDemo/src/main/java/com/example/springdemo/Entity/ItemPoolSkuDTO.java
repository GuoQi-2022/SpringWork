package com.example.springdemo.Entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPoolSkuDTO {
    /**
     * skuId
     */
    private Long skuId;

    private Long itemId;

    private BigDecimal coupon;

    private BigDecimal retailPrice;

    //订购价在C端使用时结合企业id查询
    private BigDecimal purchasePrice;

    private String itemName;

    private ItemDigestDTO itemInfo;

    private String packetId;

}
