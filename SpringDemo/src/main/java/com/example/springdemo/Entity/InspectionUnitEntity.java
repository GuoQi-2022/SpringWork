/*
 * @(#)ExampleEntity.java, 2020-06-14.
 * <p/>
 * Copyright 2020 T-mind, Inc. All rights reserved.
 * T-MIND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.Entity;

import java.util.Objects;

import lombok.Builder;
import lombok.Data;

/**
 * @author 刘照峰 (zfliu@tmindtech.com)
 */
@Data
@Builder
public class InspectionUnitEntity {

    private Long id;

    private String name;

    private String areaNumber;

    private String parentId;

    private Long createTime;

    private Long updateTime;

    private String inspectionId;

    private String config;

    // 0: 初始化 1: 已处理
    private Integer jobSign;

    // 1:单位 2:部门
    private Integer type;

    /**
     * 警种
     */
    private String assignPoliceType;

    /**
     * 截取单位编号
     */
    private String subDm;

    @Override
    public int hashCode() {
        return Objects.hash(config);
    }
}