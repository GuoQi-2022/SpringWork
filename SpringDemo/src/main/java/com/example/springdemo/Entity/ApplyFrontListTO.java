package com.example.springdemo.Entity;

import java.util.List;

import lombok.Data;

/**
 * @author Tmind
 */
@Data
public class ApplyFrontListTO {
    /**
     * 申请单id
     */
    private String applyId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 申请商品skuid
     */
    private List<Long> skuIds;

    /**
     * 状态 1-待审核(一审),2-待用户寄回,3-已寄送(待收货),4-退货成功,5-客服审核不通过, * 6-用户取消,7-系统取消,8-客服取消,9-等待客服确认(二审),11-客服拒绝
     */
    private Integer status;

    /**
     * 状态描述
     */
    private String statusDesc;

}
