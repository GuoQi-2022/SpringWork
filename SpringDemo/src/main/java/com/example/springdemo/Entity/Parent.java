package com.example.springdemo.Entity;

/**
 * @author wb.guoqi
 * @create 2022/4/22 10:01
 */
public class Parent {
    private static final int a = 1;

    private static final int b;

    static {
        b = 1;
        System.out.println("1.父类静态代码块：赋值b成功");
        System.out.println("1.父类静态代码块：a的值" + a);
    }

    private int c = initc();

    public Parent() {
        System.out.println("4.父类构造方式开始执行---> a:" + a + ",b:" + b);
        System.out.println("4.父类构造方式开始执行---> c:" + c);
    }

    int initc() {
        System.out.println("3.父类成员变量赋值：---> c的值" + c);
        this.c = 12;
        System.out.println("3.父类成员变量赋值：---> c的值" + c);
        return c;
    }

}
