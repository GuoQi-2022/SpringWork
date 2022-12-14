package com.springZJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springZJ.dao.BookDao;
import com.springZJ.dao.impl.BookDaoImpl;
import com.springZJ.service.BookService;
import com.springZJ.service.impl.BookServiceImpl;


/**
 * @author wb.guoqi
 * @create 2022/9/28 14:20
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext dataSourceConfig = new ClassPathXmlApplicationContext("DataSourceConfig.xml");

       /* BookDao druidDataSource = (BookDao) applicationContext.getBean("bookDao");
        druidDataSource.save();*/

        final BookDao bean = applicationContext.getBean(BookDaoImpl.class);
        bean.save();

        final BookService bookService = applicationContext.getBean(BookServiceImpl.class);
        bookService.save();

    }
}
