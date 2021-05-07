package com.example.demo.service;

import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;

import java.util.List;


public interface userService {
      int register(UserInfo user); /**检测名称是否被用 并且登记

     * 返回登录用户的user信息
     *
     * @param request
     * @return
     */
   UserInfo  login (String email ,String password);
     int  buyOnament(UserInfo user, OrnamentInfo ornament);
     int  steama_bind(UserInfo user);//绑定steam
    int  invest(UserInfo user);// 通过账户 id 更新充值
    List<UserInfo> getUserList();
    int check(String name ,String email);//是否重复名称检测
    int  stock_ornament(UserInfo user);//检测库存steam
}
