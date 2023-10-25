package com.example.springdemo.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Tmind
 */
public class VoteCounter {
    // 初始化投票结果字典
    private Map<String, Integer> votes = new HashMap<>();

    // 定义一个函数来处理用户的输入
    public void recordVote(String url, String model) {
        // 构建投票来源的键
        String voteKey = url + ":" + model;

        // 如果投票来源已经存在，则增加票数
        if (votes.containsKey(voteKey)) {
            votes.put(voteKey, votes.get(voteKey) + 1);
        }
        // 否则，新建选项并设置票数为1
        else {
            votes.put(voteKey, 1);
        }
    }

    // 显示投票结果
    public void displayVotes() {
        System.out.println("投票结果如下：");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "票");
        }
    }

    public static void main(String[] args) {
        VoteCounter counter = new VoteCounter();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入url和model（输入q以退出）：");
            String input = scanner.nextLine();
            if ("q".equals(input)) {
                break;
            }
            // 解析输入，提取url和model字段
            String[] parts = input.split(":");
            if (parts.length != 2) {
                System.out.println("输入格式错误，请使用url:model的格式");
                continue;
            }
            counter.recordVote(parts[0], parts[1]);
            counter.displayVotes();
        }
    }
}
