package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 郭旗(wb.guoqi @ mesg.corp.netease.com)
 * @create 2021/7/2 17:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlatformPriceDTO {
    /**
     * 平台编码
     */
    private String platformCode;
    /**
     * 平台名
     */
    private String platformName;
    /**
     * 最低价格
     */
    private Double bottomPrice;
    /**
     * 最低价格
     */
    private Integer heightPrice;

}
