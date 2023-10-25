package com.example.springdemo.Utils;

import java.security.MessageDigest;

public class Md5Util {

    private static final String[] hexDigits = new String[] { "0", "1", "2", "3", "4", "5", "6", "7",
        "8", "9", "a", "b", "c", "d", "e", "f" };

    public Md5Util() {}

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();

        for (int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    public static String encode(String origin) {
        String resultString = null;

        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return resultString;
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (b < 0) {
            n = 256 + b;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
