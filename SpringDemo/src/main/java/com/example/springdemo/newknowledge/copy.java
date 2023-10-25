package com.example.springdemo.newknowledge;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author wb.guoqi
 * @create 2021/8/27 17:15
 */
public class copy {
    public static void main(String[] args) {
        List<String> slive = new LinkedList<>();
        slive.add("商详入口");
        /*slive.add("adf");
        slive.add("adf");*/
        String liveEntranceTaskString = slive.toString();
        String substring = liveEntranceTaskString.substring(1, liveEntranceTaskString.length() - 1);
        String replace = substring.replace(",", "、");
        System.out.println(replace);
    }

}
