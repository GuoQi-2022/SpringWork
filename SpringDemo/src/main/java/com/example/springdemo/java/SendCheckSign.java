package com.example.springdemo.java;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.example.springdemo.Entity.SendCouponUnionReq;
import com.example.springdemo.Utils.Md5Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendCheckSign {

    private static final String icbc_Test = "8e5b94b3832b172b88b11fe334ebee67";

    private static final String icbc_Online = "826458cb66123a53f8849bbf8bff50fe";

    public static void main(String[] args) {
        String ksy = icbc_Test;
        String icbc = "{\"couponId\": 11503,\"channelId\": 6909534,\"unionUserIds\": [\"201511300025429190\",\"95B6BF529AF44F29AF7DA1959CE40EF5\"],\"num\": 1,\"register\": false,\"sign\":\"db8380618bf5629e4d08bd8a586fa514\"}";
        final SendCouponUnionReq couponUnionReq = JSONObject.parseObject(icbc, SendCouponUnionReq.class);
        final String sign = getSign(couponUnionReq, ksy);
        System.out.println("sign = " + sign);
        System.out.println(sign.equals(couponUnionReq.getSign()));
    }

    /**
     * 签名 (32位小写)
     *
     * @param param
     *            入参实体类
     * @param signKey
     *            加签key
     * @return 加签后sign值
     */
    public static String getSign(Object param, String signKey) {
        Class<?> paramClass = param.getClass();
        Field[] fields = paramClass.getDeclaredFields();
        //剔除入参中的sign，因为这变量不参与加签
        List<Field> signField = Arrays.stream(fields).filter(f -> !"sign".equals(f.getName()))
            .collect(Collectors.toList());
        Map<String, String> paramValue = new HashMap<>();
        //遍历变量值，进行URLEncoder操作
        signField.forEach(f -> {
            try {
                f.setAccessible(true);
                Object value = f.get(param);
                String encodeValue = URLEncoder.encode(value + "", "utf8");
                paramValue.put(f.getName(), encodeValue);
            } catch (IllegalAccessException | UnsupportedEncodingException e) {}
        });
        //按变量名进行自然排序
        List<String> sortField = signField.stream().map(f -> f.getName()).sorted().collect(Collectors.toList());
        String paramStr = "";
        for (String field: sortField) {
            if (StringUtils.isEmpty(paramStr)) {
                paramStr = paramStr + field + "=" + paramValue.get(field);
            } else {
                paramStr = paramStr + "&" + field + "=" + paramValue.get(field);
            }
        }
        //在后面拼接signKey值
        return Md5Util.encode(paramStr.toLowerCase() + signKey);
    }
}
