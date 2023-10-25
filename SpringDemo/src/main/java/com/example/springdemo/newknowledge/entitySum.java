package com.example.springdemo.newknowledge;

import java.util.HashMap;
import java.util.Map;

public class entitySum {
    public static void main(String[] args) {
        groupList();
    }

    public static void groupList() {
        Map<Integer, Integer> map = new HashMap<>(16);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            map.put(i, i);
        }
        System.out.println("指定大小16耗时为：" + (System.currentTimeMillis() - start));

        Map<Integer, Integer> map02 = new HashMap<>(100000);
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            map02.put(i, i);
        }
        System.out.println("指定大小200耗时为：" + (System.currentTimeMillis() - start));
    }
}
