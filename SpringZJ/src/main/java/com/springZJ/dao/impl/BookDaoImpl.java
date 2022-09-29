package com.springZJ.dao.impl;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springZJ.dao.BookDao;


/**
 * @author wb.guoqi
 * @create 2022/9/28 11:34
 */
@Repository
public class BookDaoImpl implements BookDao {

    private String dateBaseName;
    private Properties properties;
    private int connectionName;

    public BookDaoImpl(String dateBaseName, Properties properties, int connectionName) {
        this.dateBaseName = dateBaseName;
        this.properties = properties;
        this.connectionName = connectionName;
    }

    public BookDaoImpl() {
    }

    public BookDaoImpl(int connectionName) {
        this.connectionName = connectionName;
    }

    public BookDaoImpl(Properties properties) {
        this.properties = properties;
    }

    public BookDaoImpl(String dateBaseName) {
        this.dateBaseName = dateBaseName;
    }

    public BookDaoImpl(Properties properties, int connectionName) {
        this.properties = properties;
        this.connectionName = connectionName;
    }

    public BookDaoImpl(String dateBaseName, Properties properties) {
        this.dateBaseName = dateBaseName;
        this.properties = properties;
    }

    public void setDateBaseName(String dateBaseName) {
        this.dateBaseName = dateBaseName;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setConnectionName(int connectionName) {
        this.connectionName = connectionName;
    }

    @Override
    public void save() {
//        properties.setProperty("key", "value");
        System.out.println("book dao save ......" + dateBaseName + "," + connectionName);
//        System.out.println(JSON.toJSONString(properties));
    }
}
