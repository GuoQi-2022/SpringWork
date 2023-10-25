package com.example.springdemo.Entity;

import java.util.List;

import com.example.springdemo.Entity.bean.OrderBasisBean;
import com.example.springdemo.Entity.bean.OrderPackageBean;
import com.example.springdemo.Entity.bean.OrderPaymentBean;
import com.example.springdemo.Entity.bean.OrderResourceBean;

import lombok.Data;

/**
 * @author ysl (wb.yeshunliang01@mesg.corp.netease.com)
 */
@Data
public class OrderDetailResultVo {
    // 基础域
    private OrderBasisBean basis;

    // 包裹域
    private List<OrderPackageBean> packages;

    // 支付域
    private OrderPaymentBean payment;

    // 价格结算域
//    private OrderCostBean cost;

    // 订单权益域
//    private OrderRightsBean rights;

    // 资源域
    private OrderResourceBean resources;

}
