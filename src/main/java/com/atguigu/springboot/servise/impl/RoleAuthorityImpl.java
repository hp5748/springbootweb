package com.atguigu.springboot.servise.impl;

import com.atguigu.springboot.entity.RoleAuthority;
import com.atguigu.springboot.mapper.RoleAuthorityMapper;
import com.atguigu.springboot.servise.RoleAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleAuthorityService")
public class RoleAuthorityImpl implements RoleAuthorityService {

    @Autowired
   RoleAuthorityMapper mapper;

    @Override
    public List<RoleAuthority> selectUserAuthority(int role_id) {

        return mapper.selectRoleAuthority(role_id);
    }


}
