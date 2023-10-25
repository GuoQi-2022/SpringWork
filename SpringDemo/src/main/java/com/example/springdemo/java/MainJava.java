package com.example.springdemo.java;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.Entity.LotteryAnnouncementMapDto;

/**
 * @author wb.guoqi
 * @create 2022/4/27 10:48
 */
public class MainJava {

    public static void main(String[] args) throws InterruptedException {
        Map<Long, List<LotteryAnnouncementMapDto>> lotteryAnnouncementMap = new HashMap<>();

        List<LotteryAnnouncementMapDto> lotteryAnnouncementMapDtos = new ArrayList<>();
        LotteryAnnouncementMapDto lotteryAnnouncement = LotteryAnnouncementMapDto.builder().build();
        lotteryAnnouncement.setItemName("Pro会员月卡");
        lotteryAnnouncement.setCdKey("s6g54sf6g54s");
        lotteryAnnouncementMapDtos.add(lotteryAnnouncement);
        LotteryAnnouncementMapDto lotteryAnnouncement2 = LotteryAnnouncementMapDto.builder().build();
        lotteryAnnouncement2.setItemName("Pro纯享年卡");
        lotteryAnnouncement2.setCdKey("s6g54sf6g54s2");
        lotteryAnnouncementMapDtos.add(lotteryAnnouncement2);

        lotteryAnnouncementMap.put(40031651072L, lotteryAnnouncementMapDtos);


        List<LotteryAnnouncementMapDto> lotteryAnnouncementMapDtos2 = new ArrayList<>();
        LotteryAnnouncementMapDto lotteryAnnouncement3 = LotteryAnnouncementMapDto.builder().build();
        lotteryAnnouncement3.setItemName("Pro会员月卡");
        lotteryAnnouncement3.setCdKey("s6g54sf6g54s");
        lotteryAnnouncementMapDtos2.add(lotteryAnnouncement3);
        lotteryAnnouncementMap.put(26229533729L, lotteryAnnouncementMapDtos2);
        String s = JSON.toJSONString(lotteryAnnouncementMap);
        System.out.println(s);


        Map<Long, List<LotteryAnnouncementMapDto>> aaa = JSONObject.parseObject(s, Map.class);
        System.out.println(JSON.toJSONString(aaa));
    }

}
