package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //    @Select("SELECT * FROM UNV_USER WHERE PUID = #{puid}")
//    User selectUser(int puid);
    @Select("SELECT * FROM UNV_USER WHERE ACCOUNT= #{account}")
    User selectUser(String account);

    //    @Select("SELECT * FROM UNV_USER a join UNV_USER_GROUP b on a.GROUP_ID=b.PUID" +
//            " join UNV_USER_ROLE c on a.ROLE_ID=c.PUID")
//    List<User> getAllUsers();
//
//    @Select("SELECT * FROM UNV_USER a join UNV_USER_GROUP b on a.GROUP_ID=b.PUID" +
//            " join UNV_USER_ROLE c on a.ROLE_ID=c.PUID WHERE a.ROLE_ID=#{role_id} ")
//    List<User> getAllUsersByRoleId(int role_id);

//    @Select("SELECT a.*,b.GROUP_NAME,c.ROLE,d.PUID func_id,d.FUNCTION_FLAG" +
//            " FROM UNV_USER a join UNV_USER_GROUP b on a.GROUP_ID=b.PUID join" +
//            " UNV_USER_ROLE c on a.ROLE_ID=c.PUID join UNV_ROLE_AUTHORITY d" +
//            " on a.role_id=d.role_id")
//    List<UserInfo> getAllUsers();
//
//    @Select("SELECT a.*,b.GROUP_NAME,c.ROLE,d.PUID func_id,d.FUNCTION_FLAG" +
//            " FROM UNV_USER a join UNV_USER_GROUP b on a.GROUP_ID=b.PUID join" +
//            " UNV_USER_ROLE c on a.ROLE_ID=c.PUID join UNV_ROLE_AUTHORITY d" +
//            " on a.role_id=d.role_id WHERE a.ROLE_ID=#{role_id} ")
//    List<UserInfo> getAllUsersByRoleId(int role_id);

    @Select("SELECT * FROM UNV_USER_GROUP WHERE PUID=#{puid} ")
    UserGroup getUserGroup(int puid);

    @Select("SELECT * FROM UNV_USER_ROLE WHERE PUID=#{puid} ")
    UserRole getUserRole(int puid);

    @Select("SELECT * FROM UNV_ROLE_AUTHORITY WHERE ROLE_ID=#{role_id} ")
    RoleAuthority getRoleAuthority(int role_id);

    @Select("SELECT * FROM UNV_USER WHERE ROLE_ID <>0")
    @Results({
            @Result(property = "userRole",column = "role_id",one=@One(select = "com.atguigu.springboot.mapper.UserMapper.getUserRole")),
            @Result(property = "userGroup",column = "group_id",one=@One(select = "com.atguigu.springboot.mapper.UserMapper.getUserGroup")),
            @Result(property = "roleAuthority",column = "role_id",one=@One(select = "com.atguigu.springboot.mapper.UserMapper.getRoleAuthority"))
    })
    List<UserInfo> getAllUsers();

    @Select("SELECT * FROM UNV_USER WHERE ROLE_ID=#{role_id}")
    @Results({
            @Result(property = "userRole",column = "role_id",one=@One(select = "com.atguigu.springboot.mapper.UserMapper.getUserRole")),
            @Result(property = "userGroup",column = "group_id",one=@One(select = "com.atguigu.springboot.mapper.UserMapper.getUserGroup")),
            @Result(property = "roleAuthority",column = "role_id",one=@One(select = "com.atguigu.springboot.mapper.UserMapper.getRoleAuthority"))
    })
    List<UserInfo> getAllUsersByRoleId(int role_id);


}
