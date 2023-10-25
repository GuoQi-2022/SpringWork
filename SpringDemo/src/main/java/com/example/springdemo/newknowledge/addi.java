package com.example.springdemo.newknowledge;

import java.util.LinkedList;
import java.util.List;

public class addi {
    public static void main(String[] args) {
        List<Long> piceArr = new LinkedList<>();
        piceArr.add(100L);
        for (int i = 1; i < 51; i++) {
            piceArr.add(piceArr.get(i - 1) - 1);
        }
        List<Long> longs = toZheKou(piceArr, 500L);
        System.out.println(longs.toString());
    }

    public static List<Long> toZheKou(List<Long> commodityPoList, Long discounts) {
        /*求和    3825*/
        long sum = commodityPoList.stream().mapToLong(Long::longValue).sum();
        /*减去优惠后    3325*/
        long numNow = sum - discounts;
        Double bl = (double) numNow / (double) sum;
        for (int i = 0; i < commodityPoList.size() - 1; i++) {
            Double p = commodityPoList.get(i) * bl;
            p = Math.ceil(p);
            Long ppp = p.longValue();
            commodityPoList.set(i, ppp);
        }
        long sumTwo = commodityPoList.stream().mapToLong(Long::longValue).sum();
        Long cha = numNow - sumTwo;
        commodityPoList.set(commodityPoList.size() - 1, commodityPoList.get(commodityPoList.size() - 1) + cha);
        return commodityPoList;
    }

}