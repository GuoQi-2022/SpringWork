package com.springZJ.service.impl;


import com.springZJ.dao.BookDao;
import com.springZJ.service.BookService;

/**
 * @author wb.guoqi
 * @create 2022/9/28 11:37
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookServiceImpl() {
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("book service save ......");
        bookDao.save();
    }

}
