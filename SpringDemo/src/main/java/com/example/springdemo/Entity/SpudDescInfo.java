/**
 * @(#)SpudDescInfo.java, 2022/1/25.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 吴文铠 (wuwenkai@corp.netease.com)
 */
@Data
@Accessors(chain = true)
public class SpudDescInfo {

    /**
     * 商品详情图文
     */
    private String desc;

    /**
     * 商品详情图片
     */
    private List<String> imgList;
}
