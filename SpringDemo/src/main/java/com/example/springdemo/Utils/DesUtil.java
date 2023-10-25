package com.example.springdemo.Utils;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author wb.guoqi
 * @create 2021/8/16 15:14
 */
public class DesUtil {
    /** 对称加解密DES密钥Key */
    public final static String KEY = "#wyyx@Key%";

    /**
     * key 不足8位补位
     */
    private static byte[] getKey() {
        Key key = null;
        byte[] keyByte = KEY.getBytes();
        // 创建一个空的八位数组,默认情况下为0
        byte[] byteTemp = new byte[8];
        // 将用户指定的规则转换成八位数组
        for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {
            byteTemp[i] = keyByte[i];
        }
        key = new SecretKeySpec(byteTemp, "DES");
        return key.getEncoded();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static String decrypt(String decryptString) throws Exception {
        byte[] sourceBytes = parseHexStr2Byte(decryptString);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(getKey(), "DES"));
        byte[] decoded = cipher.doFinal(sourceBytes);
        return new String(decoded, "gbk");
    }

    public static String encrypt(String encryptString) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(getKey(), "DES"));
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes("gbk"));
        return parseByte2HexStr(encryptedData);
    }
}
