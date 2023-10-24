package com.study;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.study.dao.BookDao;
import com.study.dao.OrderDao;
import com.study.dao.UserDao;
import com.study.service.BookService;

/**
 * @author wb.guoqi
 * @create 2022/9/28 14:20
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext dataSourceConfig = new ClassPathXmlApplicationContext("DataSourceConfig.xml");

        final BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");
        bookDao.save();


       final BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.save();

        final OrderDao orderDaoFactory = (OrderDao) applicationContext.getBean("orderDaoFactory");
        orderDaoFactory.save();

        final UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
        final UserDao userDaoBean = (UserDao) applicationContext.getBean("userDao");
        System.out.println(userDaoBean);
        userDaoBean.save();

        BookDao druidDataSource = (BookDao) dataSourceConfig.getBean("bookDao2");
        druidDataSource.save();
        DataSource comboPooledDataSource = (DataSource) dataSourceConfig.getBean("comboPooledDataSource");

        System.out.println(JSON.toJSONString(comboPooledDataSource));

    }
}
