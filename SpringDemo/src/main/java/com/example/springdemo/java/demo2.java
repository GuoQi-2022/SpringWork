package com.example.springdemo.java;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wb.guoqi
 * @create 2021/12/20 15:35
 */
@Slf4j
public class demo2 {

    public static void main(String[] args) {
        try {
            final String imageBase = getImageBase("C:\\Users\\Tmind\\Pictures\\testPage.jpg");
            final String fileFromBase64 = getFileFromBase64(imageBase);
            System.out.println(fileFromBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getImageBase(String src) throws Exception {
        //        URL url = new URL(src);
        final InputStream fileInputStream = new FileInputStream(src);
        InputStream in;
        byte[] data = null;
        try {
            in = fileInputStream;//远程文件
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }

    public static String generateImage(File fileFromBase64) {
        InputStream in;
        byte[] data = null;
        try {
//            in = fileFromBase64.getInputStream();
            in = new FileInputStream(fileFromBase64);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Base64.Encoder encoder = Base64.getEncoder();
        final String imgStr = encoder.encodeToString(data);
        generateImage(imgStr, "C:\\Users\\Tmind\\Pictures\\" + fileFromBase64.getName());
        return genDownloadUrl(fileFromBase64.getName());
    }
    public static boolean generateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        /* 图像数据为空 */
        if (imgStr == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 将Base64编码转为文件（.jpg图片）
     */
    public static String getFileFromBase64(String base64Pic) throws Exception {
        File file = null;
        OutputStream out = null;
        /* 图像数据为空 */
        if (base64Pic == null) {
        } else {
            BASE64Decoder decoder = new BASE64Decoder();
            /* 前台在用Ajax传base64值的时候会把base64中的+换成空格，所以需要替换回来。 */
            String baseValue = base64Pic.replaceAll(" ", "+");
            /* 去除base64中无用的部分 */
            byte[] b = decoder.decodeBuffer(baseValue.replace("data:image/jpeg;base64,", ""));
//            String imgFilePath = ""  + System.currentTimeMillis() + ".jpg";
            String imgFilePath = "jiaoHangImg";
            /*File file1 = new File(imgFilePath);
            *//* 判断文件路径下的文件夹是否存在，不存在则创建 *//*
            if (!file1.exists() && !file1.isDirectory()) {
                file1.mkdirs();
            }*/
            try {
                for (int i = 0; i < b.length; ++i) {
                    /* 调整异常数据 */
                    if (b[i] < 0) {
                        b[i] += 256;
                    }
                }
                file = new File(imgFilePath + "\\" + "yxUserId" + System.currentTimeMillis() + ".jpg");
//                file = new File("yxUserId" + System.currentTimeMillis() + ".jpg");
                // 如果要返回file文件这边return就可以了,存到临时文件中
                out = new FileOutputStream(file.getPath());
                out.write(b);
                out.flush();
                out.close();
                return generateImage(file);
            } catch (Exception e) {
            } finally {
                if (null != out) {
                    out.close();
                }
                file.delete();
//                file1.delete();
            }
        }
        return null;
    }
    private static String genDownloadUrl(String key) {
        return "http://" + "yanxuan" + ".nosdn.127.net/" + key;
    }
}
