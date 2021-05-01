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
    int  login (String email ,String password);
     int  buyOnament(UserInfo user, OrnamentInfo ornament);
     int  steama_bind(String steam_id ,String apikey,String url);//绑定steam
    int  invest(int id ,String money);// 通过账户 id 更新充值
    List<UserInfo> getUserList();
    int check(String name ,String email);//是否重复明检测
}
