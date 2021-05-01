package com.example.demo.Mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertToMysql {
    @Insert("insert into user(id,bio,avatar_url,inventory) values(#{id},#{bio},#{avatar_url},#{inventory})")
    void insert(User user);
}
