package com.example.demo.service;

import com.example.demo.pojo.OrnamentInfo;

import java.util.List;

public interface ornamentService {
    int addOrnament(OrnamentInfo ornament);//转变为数据库里的

    List<OrnamentInfo> ornamentList();//商品列表全部
    List<OrnamentInfo> qureyOrnamentList(String name);//搜寻商品列表全部
    List<OrnamentInfo> classOrnemntList(String name);//按类别搜寻商品
    List<OrnamentInfo> PriceOrnemntList(String name);//价格排序


}
