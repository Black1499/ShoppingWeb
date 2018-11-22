package com.dao;

import com.interfaces.UserDataBaseDao;
import com.util.JDBCUtil;
import com.vo.UserInfo;

public class UserDao implements UserDataBaseDao {
    @Override
    public int addUser(UserInfo userInfo) {
        String sql = "insert into userinfo(userName,userPassword,userPhone,userEmail) values(?,?,?,?)";
        return JDBCUtil.excuteUpdate(sql, userInfo.getUserName(), userInfo.getUserPassword(), userInfo.getUserPhone(), userInfo.getUserEmail());
    }

    @Override
    public UserInfo judgeLogin(String name, String password) {
        String sql = "select * from userinfo where userName=? or userPhone=? or userEmail=? and userPassword=?";
        return JDBCUtil.queryForObject(sql, UserInfo.class, name,name,name,password);

    }

}
