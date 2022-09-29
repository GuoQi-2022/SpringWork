package com.study.factory;

import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImpl;

/**
 * @author wb.guoqi
 * @create 2022/9/28 15:27
 */
public class UserDaoFactory {

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

}
