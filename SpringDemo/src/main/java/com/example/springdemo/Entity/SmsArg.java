package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wb.guoqi
 * @create 2021/8/25 10:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsArg {
    /**
     * 短信接收者手机号
     */
    private String phone;

    /**
     * 短信内容
     */
    private String message;

    /**
     * 手机号码所在国家电信区号(海外短信不支持中文，中文会乱码)，不传默认为中国大陆
     */
    private String ctCode;

    /**
     * 短信发送级别（1>2>3）1为最高级别，默认情况下不准使用，使用需申请, 4为特殊级别，默认情况下不允许使用，使用需申请，具体见短信级别规范; level=3,4会触发黑名单过滤
     */
    private int level = 2;

    /**
     * 严选账号，方便统计
     */
    private String uid;

    /**
     * 主题，用于打log，方便统计，例如会员生日短信“birthday”
     */
    private String topic;

    /**
     * 附加信息
     */
    private String extras;

    /**
     * 默认为false, 如果是语音验证码，则传true，注: 只有level=1才可以发送验证码，因此，此时level参数必须传1
     */
    private boolean isSound;

    /**
     * 消息traceId，用于日志追踪
     */
    private String traceId;

}
