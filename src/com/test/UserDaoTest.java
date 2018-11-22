package com.test;

import com.dao.UserDao;
import com.vo.UserInfo;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        int add = userDao.addUser(new UserInfo("cmd", "123456", "13989892211", "134@qq.com"));
//        System.out.println(add);
        UserInfo userInfo = userDao.judgeLogin("cmd", "123456");
        System.out.println(userInfo.toString());
    }
}
