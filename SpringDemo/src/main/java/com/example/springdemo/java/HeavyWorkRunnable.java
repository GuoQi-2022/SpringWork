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

import com.example.springdemo.Entity.LoginReq;
import com.example.springdemo.Utils.Md5Util;

/**
 * @author wb.guoqi
 * @create 2022/5/12 10:42
 */
public class HeavyWorkRunnable implements Runnable {
    private static String signKey = "NxBWYGMmwhDJWAHTuBDPZEIkkVcHOveG";
    @Override
    public void run() {
        LoginReq loginReq = new LoginReq();
        loginReq.setUserId("690911410086");
        loginReq.setSignType("MD5");
        loginReq.setCharset("UTF8");
        loginReq.setTimestamp(1652774156000L);
        loginReq.setUnionLogo("jiangnanbank");
        final String sign = getSign(loginReq, signKey);
        System.out.println(sign);
    }

    public static String getSign(Object param, String signKey) {
        Class<?> paramClass = param.getClass();
        Field[] fields = paramClass.getDeclaredFields();
        //剔除入参中的sign、signType和unionLogo，因为这3变量不参与加签
        List<Field> signField = Arrays.stream(fields).filter(f -> !"sign".equals(f.getName()))
                .filter(f -> !"signType".equals(f.getName())).filter(f -> !"unionLogo".equals(f.getName())).collect(Collectors.toList());
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
        List<String> sortField = signField.stream().map(f -> f.getName()).sorted()
                .collect(Collectors.toList());
        String paramStr = "";
        //拼装待MD5值
        for (String field: sortField) {
            if (StringUtils.isEmpty(paramStr)) {
                paramStr = paramStr + field + "=" + paramValue.get(field);
            } else {
                paramStr = paramStr + "&" + field + "=" + paramValue.get(field);
            }
        }
        //待MD5值转小写，并且在后面拼接signKey值
        String finalSignStr = paramStr.toLowerCase() + signKey;
        System.out.println("[op:appendSign] finalSignStr: {}" + finalSignStr);
        //返回MD5后的32位小写字符串
        return Md5Util.encode(finalSignStr);
    }

}