package com.atguigu.springboot.servise.impl;

import com.atguigu.springboot.entity.User;
import com.atguigu.springboot.entity.UserInfo;
import com.atguigu.springboot.mapper.UserMapper;
import com.atguigu.springboot.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public List<UserInfo> getAllUsersByRoleId(int role_id) {
        return mapper.getAllUsersByRoleId(role_id);
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return mapper.getAllUsers();
    }

    @Override
    public User selectUser(String account) {

        return mapper.selectUser(account);
    }

}
