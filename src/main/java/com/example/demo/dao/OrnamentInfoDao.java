package com.example.demo.dao;

import com.example.demo.pojo.OrnamentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrnamentInfoDao {
    int deleteByPrimaryKey(Integer ornamentId);

    int insert(OrnamentInfo record);

    int insertSelective(OrnamentInfo record);

    OrnamentInfo selectByPrimaryKey(Integer ornamentId);

    int updateByPrimaryKeySelective(OrnamentInfo record);

    int updateByPrimaryKey(OrnamentInfo record);

    List<OrnamentInfo> OrnamentList();//全部商品列表各种状态

}