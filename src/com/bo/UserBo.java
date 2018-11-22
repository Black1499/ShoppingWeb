package com.bo;

import com.dao.UserDao;
import com.vo.UserInfo;

public class UserBo {
    private UserDao userDao = new UserDao();

    public boolean addUser(UserInfo userInfo) {
        return userDao.addUser(userInfo) != 0 ? true : false;
    }

    public boolean judgeLogin(String name, String password) {
        return userDao.judgeLogin(name, password) != null ? true : false;
    }
}
