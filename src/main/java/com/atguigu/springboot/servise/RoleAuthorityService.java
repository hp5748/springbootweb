package com.atguigu.springboot.servise;

import com.atguigu.springboot.entity.RoleAuthority;

import java.util.List;


public interface RoleAuthorityService {

    List<RoleAuthority> selectUserAuthority(int role_id);
}
