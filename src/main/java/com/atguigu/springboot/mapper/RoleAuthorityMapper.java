package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entity.RoleAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleAuthorityMapper {
    @Select("SELECT * FROM UNV_ROLE_AUTHORITY WHERE ROLE_ID=#{role_id} ")
    List<RoleAuthority> selectRoleAuthority(int role_id);

}
