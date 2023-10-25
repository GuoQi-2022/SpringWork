package com.example.springdemo.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.example.springdemo.Entity.OrderQueryDetailResultVo;
import com.example.springdemo.LeetCode.utils.NumberUtils;

/**
 * @author wb.guoqi
 * @create 2022/2/25 10:09
 */
public class ListToLists {
    public static void main(String[] args) {
        listToLists();
    }

    private static void listToLists() {
        OrderQueryDetailResultVo orderDetail = new OrderQueryDetailResultVo();
        List<OrderQueryDetailResultVo.PackageBean> pkgBeanList = new ArrayList<>();
        OrderQueryDetailResultVo.PackageBean packageBean = new OrderQueryDetailResultVo.PackageBean();
        List<OrderQueryDetailResultVo.PackageBean.SkuBean> skuBeanList = new ArrayList<>();
        OrderQueryDetailResultVo.PackageBean.SkuBean skuBean = new OrderQueryDetailResultVo.PackageBean.SkuBean();
        OrderQueryDetailResultVo.PackageBean.WelfareSkuExtBean welfareSkuExtParamBean = new OrderQueryDetailResultVo.PackageBean.WelfareSkuExtBean();
        welfareSkuExtParamBean.setOrderItemCashPrice(BigDecimal.ONE);
        skuBean.setWelfareSkuExtParamBean(welfareSkuExtParamBean);
        skuBeanList.add(skuBean);
        packageBean.setSkuBeanList(skuBeanList);
        pkgBeanList.add(packageBean);
        orderDetail.setPkgBeanList(pkgBeanList);
        long sumOrderItemCashPrice = 0L;
        if (!CollectionUtils.isEmpty(orderDetail.getPkgBeanList())) {
            sumOrderItemCashPrice = orderDetail.getPkgBeanList().stream().map(i -> {
                if (!CollectionUtils.isEmpty(i.getSkuBeanList())) {
                    return i.getSkuBeanList().stream().map(j -> {
                        if (null != j.getWelfareSkuExtParamBean()) {
                            return NumberUtils.yuan2Fen(j.getWelfareSkuExtParamBean().getOrderItemCashPrice());
                        } else {
                            return 0L;
                        }
                    }).mapToLong(Long::valueOf).sum();
                } else {
                    return 0L;
                }
            }).mapToLong(Long::valueOf).sum();
        }
        long logisticsCashPrice = 0L;
        OrderQueryDetailResultVo.ProductBean product = new OrderQueryDetailResultVo.ProductBean();
        OrderQueryDetailResultVo.ProductBean.WelfareOrderExtParamBean welfareOrderExtParamBean = new OrderQueryDetailResultVo.ProductBean.WelfareOrderExtParamBean();
//        welfareOrderExtParamBean.setLogisticsCashPrice(BigDecimal.ONE);
//        product.setWelfareOrderExtParamBean(welfareOrderExtParamBean);
        orderDetail.setProduct(product);
        if (null != orderDetail.getProduct() && null != orderDetail.getProduct().getWelfareOrderExtParamBean()) {
            logisticsCashPrice = NumberUtils
                .yuan2Fen(orderDetail.getProduct().getWelfareOrderExtParamBean().getLogisticsCashPrice());
        }
        final long cache = sumOrderItemCashPrice + logisticsCashPrice;
        System.out.println(cache);
    }
}
