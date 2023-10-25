package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 郭旗(wb.guoqi @ mesg.corp.netease.com)
 * @create 2021/7/2 17:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkuPlatformPriceDTO {
    /**
     * skuId
     */
    private Integer skuId;

    /**
     * 平台价格信息
     */
    private List<PlatformPriceDTO> platformPriceList;

    public static SkuPriceAndErrorVo dtoToVo(SkuPlatformPriceDTO skuPlatformPriceDTO) {
        SkuPriceAndErrorVo skuPriceAndErrorVo = new SkuPriceAndErrorVo();
        skuPriceAndErrorVo.setSkuId(skuPlatformPriceDTO.getSkuId());
        skuPriceAndErrorVo.setPlatformPriceList(skuPlatformPriceDTO.getPlatformPriceList());
        return skuPriceAndErrorVo;
    }
}
