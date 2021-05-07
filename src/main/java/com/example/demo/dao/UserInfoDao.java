package com.example.demo.dao;

import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo  login (String email ,String password);
    int  buyOnament(UserInfo user, OrnamentInfo ornament);
//    int  steama_bind(String steam_id ,String apikey,String url);//绑定steam
//    int  invest(int id ,String money);// 通过账户 id 更新充值
    int check(String name ,String email);//是否重复名字检测
    List<UserInfo> getUserList();



}