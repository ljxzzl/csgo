package com.example.demo.Mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user_info(username,password,SteamID,SteamUrl) values(#{username},#{password},#{SteamID},#{SteamUrl})")
    void insert(User user);
    @Select("select * from user_info where SteamID = #{SteamID}")
    User findById(@Param("SteamId") String SteamID);
    @Select("select * from user_info where password = #{password}")
    User findByPwd(@Param("password") String password);
    @Select("select * from user_info where username = #{userName}")
    User findByUserName(@Param("userName") String userName);
}
