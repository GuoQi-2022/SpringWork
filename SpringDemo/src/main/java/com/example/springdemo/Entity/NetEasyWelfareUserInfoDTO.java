package com.example.springdemo.Entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tmind
 * @description: 杭银积分兑换发放福粒
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NetEasyWelfareUserInfoDTO {
    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 发放金额（1、传的是福粒金额，不是福粒数量；2、大于0小于50000的正数，支持到小数点后两位）
     */
    private BigDecimal sendAmount;
}
