package com.example.springdemo.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 比价周期(0默认长期比价；1阶段比价)
 * 
 * @author: guoqi
 * @date: 2022/8/3
 */
@Getter
@AllArgsConstructor
public enum PeriodicalEnum {

    /**
     * 长期比价
     */
    LONG_TERM(0),

    /**
     * 阶段比价
     */
    STAGE(1),

    ;

    private final Integer value;

    public static PeriodicalEnum valuesOf(Integer value) {

        for (PeriodicalEnum adTypeEnum: PeriodicalEnum.values()) {
            if (adTypeEnum.value.equals(value)) {
                return adTypeEnum;
            }
        }
        return null;
    }

}
