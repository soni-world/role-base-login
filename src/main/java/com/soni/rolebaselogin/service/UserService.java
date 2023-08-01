package com.soni.rolebaselogin.service;

import com.soni.rolebaselogin.model.UserInfo;

public interface UserService {
    String addUser(UserInfo userInfo);

    String deleteUser(String userName);
}
