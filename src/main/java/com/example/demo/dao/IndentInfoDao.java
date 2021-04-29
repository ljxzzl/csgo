package com.example.demo.dao;

import com.example.demo.pojo.IndentInfo;

public interface IndentInfoDao {
    int deleteByPrimaryKey(Integer indentId);

    int insert(IndentInfo record);

    int insertSelective(IndentInfo record);

    IndentInfo selectByPrimaryKey(Integer indentId);

    int updateByPrimaryKeySelective(IndentInfo record);

    int updateByPrimaryKey(IndentInfo record);
}