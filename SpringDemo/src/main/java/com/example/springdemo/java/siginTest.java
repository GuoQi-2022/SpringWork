package com.example.springdemo.java;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.springdemo.Entity.SinoReq;
import com.example.springdemo.Utils.Md5Util;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;

/**
 * @author wb.guoqi
 * @create 2022/5/23 9:26
 */
@Slf4j
public class siginTest {
        private static final String signKeyszfdrstest = "c2bd5ed4a69af0d95d71d9292e22a4cb";
//    private static final String CHARSET = StandardCharsets.UTF_8;
    private static final String CHARSET = "UTF-8";
    private static final char[] strDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};
    //        private static final String signKeyszfdrstest = "0d0117d726d823bb322628faa8cf01c1";

    public static void main(String[] args) {
        String userId = "20210000000031090832";
        Long timestamp = 1654133233L;
        System.out.println("sign      --->" + "9d112ee1b1e6ce8a4a88671bdfca96c4");
        try {
            Map<String, Object> signMap = new HashMap<>();
            signMap.put("userId", userId);
//            signMap.put("timestamp", timestamp);
            final String sign = sign(signMap);
            System.out.println("sign      --->" + sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String jsonIdByMap(Map<String, String> map) {
        List<String> keyList = new ArrayList<String>(map.keySet());
        String md5 = "";
        Collections.sort(keyList);
        for (int i = 0; i < keyList.size(); i++) {
            md5 += map.get(keyList.get(i)) + "_";
        }
        md5 = md5.substring(0, md5.length() - 1);
        md5 += "@sino-life.com";
        return Md5Util.encode(md5);
    }

    public static String sign(Object data) {
        Map<String, String> map = JSONObject.parseObject(JSON.toJSONString(data),
                new TypeReference<Map<String, String>>() {});
        return jsonIdByMap(map);
    }

    // 富德操作成功标识：1，200
    private static final List<String> SUCCESS_RESULT_CODE = Arrays.asList("1", "200");

   /* public static boolean checkRequestSuccess(HttpResultBean resultBean) {
        if (resultBean == null || !resultBean.isCallSucc() || !resultBean.isVerifySucc()) {
            return false;
        }
        String content = resultBean.getContent();
        JSONObject jsonObject = JSONObject.parseObject(content);
        JSONObject data = jsonObject.getJSONObject("data");
        if (data == null || !SUCCESS_RESULT_CODE.contains(data.getString("resultCode"))) {
            return false;
        }
        return true;
    }*/

}
