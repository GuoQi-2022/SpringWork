/**
 * @(#)UserSearch.java, 2022/4/2.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author 郭旗(wb.guoqi @ mesg.corp.netease.com)
 */
@Data
public class UnifiedErrorMsgBean<T> {
    /**
     * OrderErrorMsgBean
     */
    private String beanType;

    /**
     * 异常详细内容，可以看下面的以1003003异常响应做例子的格式 OrderErrorMsgBean
     * 或Toast文案
     */
    private T bean;

}