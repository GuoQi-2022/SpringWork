/**
 * @(#)test.java, 2023/8/21.
 * <p/>
 * Copyright 2023 T-mind, Inc. All rights reserved.
 * T-mind PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.springdemo.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Tmind
 * @date 2023/8/21
 */
@Slf4j
public class test {

    public static void main(String[] args) {
        List<BigDecimal> welfareInfo = new ArrayList<>();
        welfareInfo.add(BigDecimal.ONE);
        welfareInfo.add(BigDecimal.ONE);
        welfareInfo.add(BigDecimal.ONE);
        welfareInfo.add(BigDecimal.ONE);
        BigDecimal collect = welfareInfo.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(collect);

    }

}
