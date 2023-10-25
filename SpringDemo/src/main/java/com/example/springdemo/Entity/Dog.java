package com.example.springdemo.Entity;

/**
 * @author wb.guoqi
 * @create 2022/11/17 17:10
 */

public class Dog extends Animal {

    public Dog() {
        super();
    }

    @Override
    public void eat() {
        System.out.println("我实现了父类方法，狗吃肉");
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("finalize");
    }
}
