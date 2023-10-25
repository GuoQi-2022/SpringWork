package com.example.springdemo.Entity;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscountsSkuPriceDto {
    /**
     * 套餐福粒价格（不含运费）
     */
    private BigDecimal                  setPrice;
    /**
     * 套餐价与原总价优惠的金额
     */
    private BigDecimal                  discount;
    /**
     * 商品总价
     */
    private BigDecimal                  totalPrice;
    /**
     * 兑换数量
     */
    private List<DiscountsSkuPriceList> discountsSkuPriceLists;

}
