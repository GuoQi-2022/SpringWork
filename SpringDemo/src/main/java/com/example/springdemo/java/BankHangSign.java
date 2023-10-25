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
import com.example.springdemo.Entity.BankHangSendWelfareReq;
import com.example.springdemo.Utils.Md5Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BankHangSign {

    private static final String signKey = "83fb8abbeb1878e577b8e438b96acbe5";

    public static void main(String[] args) {
        String str = "{\"enterpriseNo\":\"6909530\",\"type\":1,\"actName\":\"杭银测试2\",\"actEndTime\":1669776046000,\"userInfos\":[{\"phone\":\"18989242532\",\"userName\":\"罗\",\"sendAmount\":50000.01},{\"phone\":\"18989240002\",\"userName\":\"李四\",\"sendAmount\":10.01}]}";
        final BankHangSendWelfareReq req = JSONObject.parseObject(str, BankHangSendWelfareReq.class);
        final String realSign = getSign(req, signKey);
        System.out.println(realSign);
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
        String finalSignStr = paramStr.toLowerCase() + signKey;
        log.info("[op:appendSign] finalSignStr: {}", finalSignStr);
        return Md5Util.encode(finalSignStr);
    }
}
