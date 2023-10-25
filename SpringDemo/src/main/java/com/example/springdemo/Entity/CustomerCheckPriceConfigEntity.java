package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 比价配置表
 * 
 * @author Tmind
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCheckPriceConfigEntity {
    private Long id;

    /**
     * 企业id
     */
    private Long customerId;

    /**
     * 比价结果(0：未比价，1：异常， 2：正常)
     */
    private Integer checkResult;

    /**
     * 商品隐藏数量
     */
    private Integer hideNum;

    /**
     * 比价平台配置（[]无配置；mainsiteProm严选官网活动价、tb天猫、jd京东）
     */
    private String checkList;

    /**
     * 比价异常处理(0无处理；1异常自动隐藏；2异常自动隐藏+恢复自动展示) ExceptionHandlingAsEnum
     */
    private Integer exceptionHandlingAs;

    /**
     * 比价周期(0默认长期比价；1阶段比价) PeriodicalEnum
     */
    private Integer periodical = 0;

    /**
     * 阶段比价开始时间
     */
    private Long startTime = 0L;

    /**
     * 阶段比价结束时间
     */
    private Long endTime = 0L;

    private Long createTime;

    private Long updateTime;
}
