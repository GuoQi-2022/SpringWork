package com.study.service.impl;

import com.study.dao.BookDao;
import com.study.dao.UserDao;
import com.study.service.BookService;

/**
 * @author wb.guoqi
 * @create 2022/9/28 11:37
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    private UserDao userDao;

    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    public BookServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookServiceImpl() {
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("book service save ......");
        bookDao.save();
    }

}
