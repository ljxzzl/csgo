package com.example.demo.service;

import com.example.demo.pojo.ClassInfo;
import com.example.demo.pojo.FavoriteInfo;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;

import java.util.List;

public interface favoriteService {
    int addfavorite( FavoriteInfo favoriteInfo);//添加喜欢物品信息

    List<FavoriteInfo> getUserFavoriteList(int s);//获取用户自己喜欢的列表


}
