package com.example.springdemo.Utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @Author wb.guoqi
 * @create 2021/8/16 16:53
 */
public class Base64Util {

    static private final int BASELENGTH = 128;

    static private final int LOOKUPLENGTH = 64;

    static private final int TWENTYFOURBITGROUP = 24;

    static private final int EIGHTBIT = 8;

    static private final int SIXTEENBIT = 16;

    static private final int FOURBYTE = 4;

    static private final int SIGN = -128;

    static private final char PAD = '=';

    static private final boolean fDebug = false;

    static final private byte[] base64Alphabet = new byte[BASELENGTH];

    static final private char[] lookUpBase64Alphabet = new char[LOOKUPLENGTH];
    private static final char[] CHARS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
        'd', 'e', 'f' };

    static {
        for (int i = 0; i < BASELENGTH; ++i) {
            base64Alphabet[i] = -1;
        }
        for (int i = 'Z'; i >= 'A'; i--) {
            base64Alphabet[i] = (byte) (i - 'A');
        }
        for (int i = 'z'; i >= 'a'; i--) {
            base64Alphabet[i] = (byte) (i - 'a' + 26);
        }

        for (int i = '9'; i >= '0'; i--) {
            base64Alphabet[i] = (byte) (i - '0' + 52);
        }

        base64Alphabet['+'] = 62;
        base64Alphabet['/'] = 63;

        for (int i = 0; i <= 25; i++) {
            lookUpBase64Alphabet[i] = (char) ('A' + i);
        }

        for (int i = 26, j = 0; i <= 51; i++, j++) {
            lookUpBase64Alphabet[i] = (char) ('a' + j);
        }

        for (int i = 52, j = 0; i <= 61; i++, j++) {
            lookUpBase64Alphabet[i] = (char) ('0' + j);
        }
        lookUpBase64Alphabet[62] = '+';
        lookUpBase64Alphabet[63] = '/';

    }

    public static String encode(String text) {
        try {
            return URLEncoder.encode(text, "UTF-8");
        } catch (Exception e) {
            return text;
        }
    }

    public static String encodeMap(Map<?, ?> map) {
        List<String> lines = new ArrayList<>();
        for (Map.Entry<?, ?> entry: map.entrySet()) {
            lines.add(entry.getKey() + "=" + entry.getValue());
        }
        return StringUtils.join(lines, "&");
    }

    public static String decode(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (Exception e) {
            return text;
        }
    }

    public static String ASCIIHex(String text) {
        byte[] bytes = text.getBytes();
        char[] chars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            chars[2 * i] = CHARS[bytes[i] >> 4];
            chars[2 * i + 1] = CHARS[bytes[i] % 16];
        }
        return new String(chars).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(ASCIIHex("zh-CN&641630"));
    }
}
