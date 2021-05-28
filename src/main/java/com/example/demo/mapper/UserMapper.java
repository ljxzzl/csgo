package com.example.demo.mapper;

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
}
