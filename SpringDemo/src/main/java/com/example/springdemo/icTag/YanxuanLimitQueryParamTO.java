package com.example.springdemo.icTag;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tmind
 */
@Data
@Builder
public class YanxuanLimitQueryParamTO {

    private Boolean historyCountCache;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 限购类型 12
     */
    private List<Integer> limitPurchaseTypeList;

    /**
     * 业务key
     */
    private List<String> businessKeyList;

    /**
     * skuList 实际并不能按sku查询
     */
    private List<Object> skuList;

}
