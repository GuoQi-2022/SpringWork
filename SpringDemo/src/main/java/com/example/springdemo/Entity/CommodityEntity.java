package com.example.springdemo.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommodityEntity {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 商品ID
     */
    private long commodityId;
    /**
     * 规格名称
     */
    private String modelName;
    /**
     * 库存
     */
    private int sellVolume;
    /**
     * SKUID
     */
    private Long skuId;
    /**
     * 基准零售价（分）
     */
    private Long retailPrice;
    /**
     * 兑换数量
     */
    private Integer changeNum;
    /**
     * 套餐组ID
     */
    private Long commodityGroupId;
    /**
     * 商品顺序
     */
    private Long orderId;
    /**
     * 删除
     */
    private Integer deleted;
    /**
     * 创建人
     */
    private String createUid;
    /**
     * 修改人
     */
    private String updateUid;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 修改时间
     */
    private Long updateTime;
}
