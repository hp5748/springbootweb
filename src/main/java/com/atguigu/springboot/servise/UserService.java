package com.atguigu.springboot.servise;

import com.atguigu.springboot.entity.User;
import com.atguigu.springboot.entity.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> getAllUsersByRoleId(int role_id);
    List<UserInfo> getAllUsers();
    User selectUser(String account);

}
