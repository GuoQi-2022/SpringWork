package com.study.dao.impl;

import com.study.dao.BookDao;

/**
 * @author wb.guoqi
 * @create 2022/9/28 11:34
 */
public class BookDaoImpl implements BookDao {

    private final String dateBaseName;

    private final int connectionName;

    public BookDaoImpl(String dateBaseName, int connectionName) {
        this.dateBaseName = dateBaseName;
        this.connectionName = connectionName;
    }

    @Override
    public void save() {
        System.out.println("book dao save ......" + dateBaseName + "," + connectionName);
    }
}
