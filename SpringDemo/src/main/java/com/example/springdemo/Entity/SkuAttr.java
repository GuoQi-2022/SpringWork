/**
 * @(#)SkuAttr.java, 2022/1/25.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 吴文铠 (wuwenkai@corp.netease.com)
 */
@Data
@Accessors(chain = true)
public class SkuAttr {

    /**
     * 销售属性key（自定义）
     */
    @JSONField(name = "attr_key")
    private String attrKey;

    /**
     * 销售属性value（自定义）
     */
    @JSONField(name = "attr_value")
    private String attrValue;

}