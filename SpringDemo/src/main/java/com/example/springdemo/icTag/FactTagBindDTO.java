package com.example.springdemo.icTag;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tmind
 */
@Data
@Builder
public class FactTagBindDTO {

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 扩展信息
     */
    private String extInfo;

    /**
     * 实体id
     */
    private String factId;

    /**
     * 实体类型 TagFactTypeEnum
     */
    private Integer factType;

    /**
     * 标签编码
     */
    private String tagKey;

    /**
     * 标签值
     */
    private String tagValue;

    /**
     * 更新时间
     */
    private Long updateTime;

}
