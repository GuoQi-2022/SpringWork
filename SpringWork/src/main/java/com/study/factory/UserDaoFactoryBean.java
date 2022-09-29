package com.study.factory;

import org.springframework.beans.factory.FactoryBean;

import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImpl;

/**
 * @author wb.guoqi
 * @create 2022/9/28 15:27
 */
public class UserDaoFactoryBean implements FactoryBean<UserDao> {

    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

}
