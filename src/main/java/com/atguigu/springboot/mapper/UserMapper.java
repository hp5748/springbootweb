package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

//    @Select("SELECT * FROM UNV_USER WHERE PUID = #{puid}")
//    User selectUser(int puid);
    @Select("SELECT * FROM UNV_USER WHERE ACCOUNT= #{account}")
    User selectUser(String account);
}
