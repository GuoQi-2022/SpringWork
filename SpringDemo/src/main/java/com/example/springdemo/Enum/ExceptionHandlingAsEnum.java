package com.example.springdemo.Enum;

/**
 * @author 郭旗(wb.guoqi@mesg.corp.netease.com)
 */
public enum ExceptionHandlingAsEnum implements EnumIntegerInterface {

    /**
     * 无处理
     */
    NOTHING(0, "无处理"),

    /**
     * 异常自动隐藏
     */
    EXCEPTION_CONCEAL(1, "异常自动隐藏"),

    /**
     * 异常自动隐藏+恢复自动展示
     */
    EXCEPTION_CONCEAL_RECOVER(2, "异常自动隐藏+恢复自动展示"),

    /**
     * 跟价
     */
    FOLLOW_PRICE(3, "跟价"),;

    private final int value;

    private final String desc;

    ExceptionHandlingAsEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}
