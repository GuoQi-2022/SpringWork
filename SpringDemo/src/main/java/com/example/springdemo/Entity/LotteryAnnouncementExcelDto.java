package com.example.springdemo.Entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tmind
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LotteryAnnouncementExcelDto {

    /**
     * 中奖商品名
     */
    @Excel(name = "奖品名称")
    private String itemName;

    /**
     * 福礼用户id
     */
    @Excel(name = "福礼用户id")
    private String userId;

    /**
     * 商品兑换码
     */
    @Excel(name = "奖品兑换码")
    private String cdKey;
}
