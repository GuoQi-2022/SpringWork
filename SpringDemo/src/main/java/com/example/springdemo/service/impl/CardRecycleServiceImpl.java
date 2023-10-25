package com.example.springdemo.service.impl;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import com.example.springdemo.Utils.DateUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.springdemo.service.CardRecycleService;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Service
@Slf4j
public class CardRecycleServiceImpl implements CardRecycleService {
    private final static int PWD_LENGTH = 1;

    private final static int PWD_UPPER_LENGTH = 4;

    private final List<Integer> exportChar = new ArrayList<>();


    private final List<Integer> exportUpperChar = Arrays.asList(73,79,82,85,86,105,111,114,117,118);

    @PostConstruct
    private void init() {
        exportChar.add(73);
        exportChar.add(79);
        exportChar.add(105);
        exportChar.add(108);
        exportChar.add(111);

//        exportUpperChar.add(73); //I
//        exportUpperChar.add(79); //O
//        exportUpperChar.add(82); //R
//        exportUpperChar.add(85); //U
//        exportUpperChar.add(86); //V
//        exportUpperChar.add(105);//i
//        exportUpperChar.add(111);//o
//        exportUpperChar.add(114);//r
//        exportUpperChar.add(117);//u
//        exportUpperChar.add(118);//v
    }

    @Override
    public String getPwdUpperCaseRandom() {
        String val = "";
        Random random = new Random();

        for (int i = 0; i < PWD_UPPER_LENGTH; i++) {

            int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;

            temp = (random.nextInt(26) + temp);
            while (exportUpperChar.contains(temp)) {
                temp = temp + 1;
                if (temp > 122) {
                    temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                }
            }
            val += (char) temp;
//            System.out.println(val);
        }
        return val.toUpperCase();
    }

    public String getCardNo() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        String cardNo = DateUtils.parseLongToString(DateUtils.getCurrentTime(), DateUtils.DATEYFORMAT) + this.getPwdUpperCaseRandom()
                + DateUtils.parseLongToString(DateUtils.getCurrentTime(), DateUtils.DATEMDFORMAT);
        /*while (!StringUtils.isEmpty(redisTemplate.opsForValue().get(cardNo))) {
            cardNo = DateUtils.parseLongToString(DateUtils.getCurrentTime(), DateUtils.DATEYFORMAT) + this.getPwdUpperCaseRandom()
                    + DateUtils.parseLongToString(DateUtils.getCurrentTime(), DateUtils.DATEMDFORMAT);
        }*/
//        redisTemplate.opsForValue().set(cardNo, "cardNo", 1L, TimeUnit.DAYS);
        return cardNo;
    }
}
