package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author Tmind
 */
@Data
public class SimplePhyCateGoryTO {

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 类目名
     */
    private String name;

    /**
     * 上级类目id，首级类目为0
     */
    private Long superId;

    /**
     * 类目描述
     */
    private String description;

    /**
     * 类目级别 0-首级 1-中级 2-末级
     */
    private Integer level;

    /**
     * 级别序号，由序号1从首级到末级依次递增
     */
    private Integer levelNo;

    /**
     * 同级排序值,小的置顶
     */
    private Integer rank;

    public SimplePhyCateGoryTO(Long id, Integer levelNo) {
        this.id = id;
        this.levelNo = levelNo;
    }
}
