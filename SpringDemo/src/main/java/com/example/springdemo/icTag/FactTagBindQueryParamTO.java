package com.example.springdemo.icTag;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tmind
 */
@Data
@Builder
public class FactTagBindQueryParamTO {

    /**
     * 实体id集合,单次查询最多200个实体id
     */
    private List<String> factIds;

    /**
     * 实体类型 TagFactTypeEnum
     */
    private Integer factType;

    /**
     * 分组编码，单次查询最多200个分组编码
     */
    private List<String> groupCodes;

    /**
     * 标签key集合,单次查询最多200个实体id
     */
    private List<String> tagKeys;

    /**
     * 标签值集合,单次查询最多200个实体id
     */
    private List<String> tagValues;

}
