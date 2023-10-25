package com.example.springdemo.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDigestDTO implements Serializable {

    private Long itemId; //	商品的id

    private String itemName; //商品的name

    private String picUrl; //列表图

    private String itemDesc; //商品的描述信息，如果商品设置有标签信息(制造商)，则显示制造商的tag

    private BigDecimal retailPrice; //商品中心基准价

    private BigDecimal purchasePrice; //采购价

    private Integer status; //商品状态：-1-错误，0-未上架/已下架，2-已上架


    private Long onshelfTime;

    /**
     * 二级类目id
     */
    private List<Long> category;
}
