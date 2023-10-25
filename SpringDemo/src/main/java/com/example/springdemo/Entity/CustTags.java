package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wb.guoqi
 * @create 2021/8/11 9:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustTags {
    /**
     * 系统代码
     */
    private String stmNm;

    /**
     * 返回码
     * 0000请求成功
     * 0001验证码不合法
     * 0002系统错误
     * 0003通讯故障(网络超时)
     * 0004 权限不足
     * 0005 厂商不一致
     */
    private String retCode;

    /**
     * 返回信息
     */
    private String retMsg;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 标签
     */
    private String custTagsInfo;

}
