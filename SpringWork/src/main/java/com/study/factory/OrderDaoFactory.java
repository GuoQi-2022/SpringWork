package com.study.factory;

import com.study.dao.OrderDao;
import com.study.dao.impl.OrderDaoImpl;

/**
 * @author wb.guoqi
 * @create 2022/9/28 15:27
 */
public class OrderDaoFactory {
    public static OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }
}
