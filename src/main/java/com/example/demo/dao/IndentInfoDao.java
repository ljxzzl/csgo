package com.example.demo.dao;

import com.example.demo.pojo.IndentInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IndentInfoDao {
    int deleteByPrimaryKey(Integer indentId);

    int insert(IndentInfo record);

    int insertSelective(IndentInfo record);

    IndentInfo selectByPrimaryKey(Integer indentId);

    int updateByPrimaryKeySelective(IndentInfo record);

    int updateByPrimaryKey(IndentInfo record);
}