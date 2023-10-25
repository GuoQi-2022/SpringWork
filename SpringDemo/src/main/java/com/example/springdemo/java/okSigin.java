package com.example.springdemo.java;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.example.springdemo.Entity.OkLifeLoginReq;
import com.example.springdemo.Utils.Md5Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wb.guoqi
 * @create 2022/5/23 9:26
 */
@Slf4j
public class okSigin {
    private static final String signKey = "8b56cb681b8fe18427bc4944a921c813";
    private static final String signKey_online = "d5f5318993d837abb58a7d5794670f7b";

    public static void main(String[] args) {
        OkLifeLoginReq okLifeLoginReq = new OkLifeLoginReq();
        okLifeLoginReq.setFrom("oklife");
        okLifeLoginReq.setMobile(17702237804L);
        okLifeLoginReq.setTimestamp(1653978733L);
        okLifeLoginReq.setUid("551ed22f9155860e2b19a6269f2e8361");
        okLifeLoginReq.setSign("06a04a7150ae5ff8b6294144788d23e3");
        okLifeLoginReq.setJumpUrl("");
//        final boolean b = checkSign(okLifeLoginReq, okLifeLoginReq.getSign(), signKey);
        final boolean b = checkSign(okLifeLoginReq, okLifeLoginReq.getSign(), signKey_online);

        System.out.println(b);
        //        System.out.println(Md5Util.encode("fuderenshou" + "test"));
    }

    public static boolean checkSign(Object param, String sign, String publicKey) {
        //得到MD5后的32位小写字符串
        String realSign = getSign(param, publicKey);
        System.out.println("sign=" + realSign);
        return sign.equals(realSign);
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
        return Md5Util.encode(finalSignStr);
//        return Md5Util.encode("oklifeOnline");
//        return Md5Util.encode("meicanOnline");
//        return Md5Util.encode("oklifetest");
    }
}
