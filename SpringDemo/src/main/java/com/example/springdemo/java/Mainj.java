package com.example.springdemo.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;

import com.alibaba.fastjson.JSON;

/**
 * @author wb.guoqi
 * @create 2022/4/27 10:48
 */
public class Mainj {

    public static void main(String[] args) throws InterruptedException {
        List<String> alipayFiles = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            alipayFiles.add(String.valueOf(i));
        }
        alipayFiles = alipayFiles.subList(0, Math.min(alipayFiles.size(), 30));
        List<List<String>> partition = ListUtils.partition(alipayFiles, 3);
        partition = partition.stream().filter(i -> i.size() == 3).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(partition));
    }

}
