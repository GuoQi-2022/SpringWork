package com.example.springdemo.Enum;

/**
 * @author 郭旗(wb.guoqi @ mesg.corp.netease.com)
 */
public enum ComparisonResultsEnum {

    /* 无 */
    NULL(0, "null"),

    /* 比价结果异常 */
    EXCEPTION(1, "异常"),

    /* 比价结果正常 */
    NORMAL(2, "正常");

    private final int value;

    private final String name;

    ComparisonResultsEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
