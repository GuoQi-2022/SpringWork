package com.example.springdemo.Entity;

/**
 * @author wb.guoqi
 * @create 2022/11/17 17:09
 */
public abstract class Animal {

    public void sleep() {
        System.out.println("我趴着睡");
    }
    public abstract void eat();
}
