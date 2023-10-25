package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author wb.guoqi
 * @create 2022/4/22 10:02
 */
@Data
public class Son extends Parent {
    private static final int sa = 1;

    private static final int sb;

    static {
        sb = 1;
        System.out.println("2.子类静态代码块：赋值sb成功");
        System.out.println("2.子类静态代码块：sa的值" + sa);
    }

    private int sc = initc2();

    public Son() {
        System.out.println("6.子类构造方式开始执行---> sa:" + sa + ",sb:" + sb);
        System.out.println("6.子类构造方式开始执行---> sc:" + sc);
    }

    int initc2() {
        System.out.println("5.子类成员变量赋值--->：sc的值" + sc);
        this.sc = sa + sb;
        return sc;
    }
}
