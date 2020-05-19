package com.atguigu.springboot.servise;

import com.atguigu.springboot.entity.User;

import java.util.List;

public interface UserService {

    User selectUser(String account);

}
