package com.example.springdemo.java;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.Entity.OkLifeLoginReq;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;

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
import com.example.springdemo.Entity.LoginReq;
import com.example.springdemo.Utils.Md5Util;

/**
 * @author wb.guoqi
 * @create 2022/5/23 9:26
 */
@Slf4j
public class sigin {
    private static final String signKey = "NxBWYGMmwhDJWAHTuBDPZEIkkVcHOveG";
    private static final String signKeyShanDe = "a489ad7148f715205bf216ee98fcf042";
    private static final String signKeyjiangnanbank = "3403213f38b51fe5b2f6a45b8458115f";
    private static final String signKeyszfdrs = "c2bd5ed4a69af0d95d71d9292e22a4cb";
    private static final String signKeyszfdrsonline = "0d0117d726d823bb322628faa8cf01c1";
    private static final String signKeymeicanonline = "da57a32d44fc2db7c98b20827bcca762";
    private static final String signKeymeicantest = "77354259435016131e24bf4747ccb7a7";
    private static final String signKeypinnuoonline = "f40f84bfb73846f5954f8db217cfcbea";
    private static final String signKeypinnuotest = "1d7aa431a69a455389fc456a5efad1ef";
    private static final String signKeyJiaohang = "3ab5185ddeef43ce77548682f4a5c373";
    private static final String signKeyJiaohangOnline = "1f5463f56862aa883b5a877e844548fe";
    private static final String signKeyYouFuOnline = "ZfibhfRrmbswbTmlguGOnFdvshIYBtWB";
    private static final String signKeyYouFuTest = "NxBWYGMmwhDJWAHTuBDPZEIkkVJCLDoN";
    private static final String signKeyanfubaoliandengTest = "67e5d4be82777fc3b5a54509682caf1f";
    private static final String signKeyanfubaoliandengOnline = "c867683242555c6626a1e6b18ce4aa8f";
    public static void main(String[] args) {
        /*String ksy = signKeyYouFuOnline;
        String szfdrs = "{\n" +
                "    \"charset\": \"UTF8\",\n" +
                "    \"sign\": \"3f3aeb82d454e5f4c3d1e903e66b78e6\",\n" +
                "    \"signType\": \"MD5\",\n" +
                "    \"timestamp\": 1669366144,\n" +
                "    \"unionLogo\": \"youfu\",\n" +
                "    \"userId\": \"475023\"\n" +
                "}";*/
/*
        String ksy = signKeyJiaohang;
        String szfdrs = "{\n" +
                "    \"charset\": \"UTF8\",\n" +
                "    \"sign\": \"3f3aeb82d454e5f4c3d1e903e66b78e6\",\n" +
                "    \"signType\": \"MD5\",\n" +
                "    \"timestamp\": 1669366144,\n" +
                "    \"unionLogo\": \"youfu\",\n" +
                "    \"userId\": \"475023\"\n" +
                "}";
*/
/*        String ksy = signKeyjiangnanbank;
        String szfdrs = "{\n" +
                "   \n" +
                "    \"userId\":\"11255212552125906342998638011235\",\n" +
                "    \"charset\":\"UTF8\",\n" +
                "    \"timestamp\":1653553031,\n" +
                "    \"signType\":\"MD5\",\n" +
                "    \"unionLogo\":\"jiangnanbank\",\n" +
                "    \"sign\":\"941f080796c3d1q1917b7003b99acb05\"\n" +
                "    \n" +
                "}";*/
        /*String ksy = signKeyszfdrsonline;
        String szfdrs = "{\n" +
                "   \n" +
                "    \"userId\":\"20210000000029855024\",\n" +
                "    \"charset\":\"UTF8\",\n" +
                "    \"timestamp\":1654827525,\n" +
                "    \"signType\":\"MD5\",\n" +
                "    \"unionLogo\":\"szfdrs\",\n" +
                "    \"sign\":\"be6e4fcd90e6153fecfa3ec257f15caa\"\n" +
                "    \n" +
                "}";*/
        /*String ksy = signKeyShanDe;
        String szfdrs = "{\n" +
                "   \n" +
                "    \"userId\":\"123456\",\n" +
                "    \"charset\":\"UTF8\",\n" +
                "    \"timestamp\":1653472649000,\n" +
                "    \"signType\":\"MD5\",\n" +
                "    \"unionLogo\":\"shande\",\n" +
                "    \"sign\":\"4fe8915f3f735bb44d75ecf8f8e92d05\"\n" +
                "    \n" +
                "}";*/
        /*String ksy = signKeyszfdrs;
        String szfdrs = "{\n" +
                "   \n" +
                "    \"userId\":\"20210000000031085316\",\n" +
                "    \"charset\":\"UTF8\",\n" +
                "    \"timestamp\":1654827525,\n" +
                "    \"signType\":\"MD5\",\n" +
                "    \"unionLogo\":\"szfdrs\",\n" +
                "    \"sign\":\"526421a0abd08be6ac822212536021a8\"\n" +
                "    \n" +
                "}";*/
        /*String ksy = signKeymeicantest;
        String szfdrs = "{\n" +
                "   \n" +
                "    \"userId\":\"84973102207927296\",\n" +
                "    \"charset\":\"UTF8\",\n" +
                "    \"timestamp\":1664156593,\n" +
                "    \"signType\":\"MD5\",\n" +
                "    \"unionLogo\":\"meican\",\n" +
                "    \"sign\":\"6917d90881cecd72d825d189e1743302\"\n" +
                "    \n" +
                "}";*/
        String ksy = signKeyanfubaoliandengTest;
        String szfdrs = "{\n" +
                "    \"from\":\"anfubaoliandeng\",\n" +
                "    \"jumpUrl\":\"\",\n" +
                "    \"mobile\":17702237804,\n" +
                "    \"sign\":\"3813ec12da5b1d8717cc60f042114189\",\n" +
                "    \"timestamp\":1653978733,\n" +
                "    \"uid\":\"551ed22f9155860e2b19a6269f2e8361\"\n" +
                "}";
        final OkLifeLoginReq loginReq1 = JSONObject.parseObject(szfdrs, OkLifeLoginReq.class);
        final String sign = getSign(loginReq1, ksy);
        loginReq1.setSign(sign);
        System.out.println("sign = " + JSON.toJSONString(loginReq1));
        /*String ksy = signKeypinnuotest;
        String pinnuo = "{\n" +
                "    \"charset\": \"UTF8\",\n" +
                "    \"sign\": \"f338be2c2b7a422e663784e1b9a0cd59\",\n" +
                "    \"signType\": \"MD5\",\n" +
                "    \"timestamp\": 1664156593,\n" +
                "    \"unionLogo\": \"pinnuo\",\n" +
                "    \"userId\": \"84912101107020406\"\n" +
                "}";
        final LoginReq loginReq1 = JSONObject.parseObject(pinnuo, LoginReq.class);
        System.out.println(JSON.toJSONString(loginReq1));
        final String sign = getSign(loginReq1, ksy);
        System.out.println("sign = " + sign);*/
    }


    /**
     * 签名 (32位小写)
     *
     * @param param        入参实体类
     * @param signKey      加签key
     * @return 加签后sign值
     */
    public static String getSign(Object param, String signKey) {
        Class<?> paramClass = param.getClass();
        Field[] fields = paramClass.getDeclaredFields();
        //剔除入参中的sign和jumpUrl，因为这2变量不参与加签
        List<Field> signField = Arrays.stream(fields).filter(f -> !"sign".equals(f.getName()))
                .filter(f -> !"jumpUrl".equals(f.getName())).collect(Collectors.toList());
        //按变量名进行自然排序
        signField = signField.stream().sorted(Comparator.comparing(Field::getName)).collect(Collectors.toList());
        LinkedHashMap<String, String> paramValue = new LinkedHashMap<>(6);
        //遍历变量值，进行URLEncoder操作
        signField.forEach(f -> {
            try {
                f.setAccessible(true);
                Object value = f.get(param);
                String encodeValue = URLEncoder.encode(value + "", "UTF-8");
                paramValue.put(f.getName(), encodeValue);
            } catch (IllegalAccessException | UnsupportedEncodingException e) {}
        });
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String mapJsonStr = gson.toJson(paramValue, new TypeToken<TreeMap<String, String>>() {}.getType());
        //在后面拼接signKey值
        String finalSignStr = Md5Util.encode(mapJsonStr) + signKey;
        log.info("[op:appendSign] mapJsonStr:{}, signKey: {}, finalSignStr: {}", mapJsonStr, signKey, finalSignStr);
//        return Md5Util.encode(finalSignStr);
        return Md5Util.encode("zhongbangOnline");
    }
}
