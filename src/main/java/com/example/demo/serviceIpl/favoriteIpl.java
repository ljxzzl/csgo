package com.example.demo.serviceIpl;

import com.example.demo.dao.ClassInfoDao;
import com.example.demo.dao.FavoriteInfoDao;
import com.example.demo.pojo.FavoriteInfo;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.favoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class favoriteIpl implements favoriteService {
    @Autowired
  FavoriteInfoDao   favoriteInfoDao;
    @Override
    public int addfavorite( FavoriteInfo favoriteInfo) {
        return favoriteInfoDao.insert(favoriteInfo);
    }

    @Override
    public List<FavoriteInfo> getUserFavoriteList(int s) {
        return favoriteInfoDao.search(s);
    }
}
