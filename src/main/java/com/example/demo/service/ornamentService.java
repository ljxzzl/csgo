package com.example.demo.service;

import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;

import java.util.List;

public interface ornamentService {
    int addOrnament(OrnamentInfo ornament);//转变为数据库里的

    List<OrnamentInfo> ornamentList();//商品列表全部
    List<OrnamentInfo> qureyOrnamentList(String name);//搜寻商品列表全部

    List<OrnamentInfo> PriceOrnemntList(String name);//价格排序

    int close(OrnamentInfo ornamentInfo);
    int  updateByUserId(String id,String parm,String ornament_price);
    OrnamentInfo selectByPrimaryKey(Integer ornamentId);
    List<OrnamentInfo> searchUser  (String userid);

}
