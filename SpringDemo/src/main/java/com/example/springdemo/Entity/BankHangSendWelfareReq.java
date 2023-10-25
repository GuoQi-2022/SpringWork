package com.example.springdemo.Entity;

import java.math.BigDecimal;
import java.util.List;

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
public class BankHangSendWelfareReq {
    /**
     * 客户号
     */
    private String enterpriseNo;

    /**
     * 发放类型【1指定账户】暂只支持这一种
     */
    private Integer type;

    /**
     * 活动批次名称（不能多于20个字）
     */
    private String actName;

    /**
     * 回收时间
     */
    private Long actEndTime;

    /**
     * 用户信息
     */
    private List<UserInfo> userInfos;

    /**
     * 加密后结果
     */
    private String sign;

    @Data
    public static class UserInfo {
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

        @Override
        public String toString() {
            return "UserInfo{" +
                    "phone='" + phone + '\'' +
                    ", userName='" + userName + '\'' +
                    ", sendAmount=" + sendAmount +
                    '}';
        }
    }
}
