package com.example.springdemo.icTag;

import java.util.Arrays;
import java.util.Optional;

import lombok.AllArgsConstructor;

/**
 * 标签实体类型枚举
 * 
 * @author 郭旗(wb.guoqi @ mesg.corp.netease.com)
 * @create 2021/11/08 11:27
 */
@AllArgsConstructor
public enum TagFactTypeEnum {

    /**
     * SPU
     */
    SPU(1, "商品"),

    /**
     * SKU
     */
    SKU(2, "sku"),

    /**
     * 物理类目
     */
    PHY_CATEGORY(3, "物理类目"),

    ;

    private Integer type;

    private String desc;

    public static String geTheValue(Integer type) {
        if (null == type) {
            return null;
        }
        Optional<TagFactTypeEnum> typeEnum = Arrays.stream(TagFactTypeEnum.values())
            .filter(t -> t.getType().equals(type)).findFirst();
        return typeEnum.map(tagFactTypeEnum -> tagFactTypeEnum.desc).orElse(null);
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
