package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 郭旗(wb.guoqi @ mesg.corp.netease.com)
 * @create 2021/7/5 10:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkuPriceAndErrorVo {
    /**
     * skuId
     */
    private Integer skuId;

    /**
     * 平台价格信息
     */
    private List<PlatformPriceDTO> platformPriceList;
    
    /**
     * 异常信息
     */
    private String errorMessage;
}
