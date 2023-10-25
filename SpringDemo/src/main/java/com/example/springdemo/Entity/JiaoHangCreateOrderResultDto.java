package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author Tmind
 */
@Data
public class JiaoHangCreateOrderResultDto {
    /**
     * 数字签名
     */
    private String appletSign = "";

    /**
     * 加密后会话密钥
     */
    private String appletKey = "";

    /**
     * 请求加密数据
     */
    private AppletRequest appletRequest;

    @Data
    public static class AppletRequest {
        /**
         * 请求时间戳（精确到毫秒）
         */
        private String requestTime;

        /**
         * 用户在小程序上的身份唯一标识
         */
        private String openid;

        /**
         * 订单有效期，以分钟为单位；不上送，则7天有效；上送，则必须在0-60分钟内;
         */
        private String invalidTime;

        /**
         * 外部商户订单号
         */
        private String mercOrderNo;

        /**
         * 统一支付商户号；商户在交行统一支付平台申请的商户号
         */
        private String merchantNo;

        /**
         * 订单金额；默认带两位小数
         */
        private String orderAmt;

        /**
         * 订单币种；目前只支持CNY
         */
        private String ccy;

        /**
         * 订单描述；用于存储业务元素信息.
         */
        private String orderDesc;

        /**
         * 用于存储相关业务需单独存储展示字段信息
         */
        private String busField1;

        /**
         * 用于存储相关业务需单独存储展示字段信息
         */
        private String busField2;

        /**
         * 用于存储相关业务需单独存储展示字段信息
         */
        private String busField3;

        /**
         * 用于存储相关业务需单独存储展示字段信息
         */
        private String busField4;

        /**
         * 用于存储相关业务需单独存储展示字段信息
         */
        private String busField5;

        /**
         * 子业务类型
         */
        private String subBizType;
    }
}
