package com.study;

import com.study.dao.UserDao;
import com.study.factory.UserDaoFactory;

/**
 * @author wb.guoqi
 * @create 2022/9/28 11:39
 */
public class App {
    public static void main(String[] args) {
        /*BookService bookService = new BookServiceImpl();
        bookService.save();*/

        /*final OrderDao orderDao = OrderDaoFactory.getOrderDao();
        orderDao.save();*/

        final UserDaoFactory userDaoFactory = new UserDaoFactory();
        final UserDao userDao = userDaoFactory.getUserDao();
        userDao.save();
    }
}
