package com.springZJ.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springZJ.dao.BookDao;
import com.springZJ.service.BookService;

/**
 * @author wb.guoqi
 * @create 2022/9/28 11:37
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("book service save ......");
        bookDao.save();
    }

}
