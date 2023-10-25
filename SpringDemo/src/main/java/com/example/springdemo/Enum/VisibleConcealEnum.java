package com.example.springdemo.Enum;

import java.util.Arrays;
import java.util.Optional;

/**
 * 比价结果 展示，隐藏
 * 
 * @author 郭旗(wb.guoqi @ mesg.corp.netease.com)
 */
public enum VisibleConcealEnum {

    /* 无 */
    NULL(0, "null"),

    /* 手动展示 */
    MANUAL_VISIBLE(1, "手动展示"),

    /* 手动隐藏 */
    MANUAL_CONCEAL(2, "手动隐藏"),

    /* 自动展示 */
    AUTOMATIC_VISIBLE(3, "自动展示"),

    /* 自动隐藏 */
    AUTOMATIC_CONCEAL(4, "自动隐藏"),

    ;

    private final Integer value;

    private final String name;

    VisibleConcealEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * 枚举值是否包含该参数
     */
    public static boolean haveIn(Integer val) {
        if (val.equals(0)) {
            return false;
        }
        final Optional<VisibleConcealEnum> any = Arrays.stream(VisibleConcealEnum.values())
            .filter(i -> i.value.equals(val)).findAny();
        return any.isPresent();
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
