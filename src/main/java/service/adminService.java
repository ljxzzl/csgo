package service;

import pojo.OrnamentInfo;
import pojo.UserInfo;

import java.util.List;

public interface adminService {


    int  login (String account ,String password);//管理员登录

    List<UserInfo> userList();//商品列表全部
    List<OrnamentInfo> OrnamentList();//商品列表全部


}
