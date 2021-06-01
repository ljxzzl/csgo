package com.example.demo.dao;

import com.example.demo.pojo.FavoriteInfo;
import com.example.demo.pojo.IndentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteInfoDao {
    int deleteByPrimaryKey(Integer favoriteId);

    int insert(FavoriteInfo record);

    int insertSelective(FavoriteInfo record);

    FavoriteInfo selectByPrimaryKey(Integer favoriteId);

    int updateByPrimaryKeySelective(FavoriteInfo record);

    int updateByPrimaryKey(FavoriteInfo record);
    List<FavoriteInfo> search(int parm);
}