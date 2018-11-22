package com.interfaces;

import com.vo.UserInfo;

public interface UserDataBaseDao {
    int addUser(UserInfo userInfo);

    UserInfo judgeLogin(String name, String password);
}
