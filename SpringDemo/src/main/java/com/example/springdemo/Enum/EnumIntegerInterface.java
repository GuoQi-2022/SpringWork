/**
 * @(#)AbstractEnumInterface.java, 2015年8月14日.
 * <p>
 * Copyright 2015 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Enum;

/**
 * 数据库中对于枚举类型字段均存储数值，故定义了获取枚举对象int值的接口
 * 定义枚举时，统一实现此接口
 *
 * @param <T> 枚举类型
 * @author hzyurui
 */
public interface EnumIntegerInterface<T extends Enum> {

    /**
     * 获得枚举的int值
     *
     * @return 当前枚举类的int值
     */
    int getValue();

}
