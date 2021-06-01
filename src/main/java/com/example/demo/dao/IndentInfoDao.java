package com.example.demo.dao;

import com.example.demo.pojo.IndentInfo;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndentInfoDao {
    int deleteByPrimaryKey(Integer indentId);

    int insert(IndentInfo record);

    int insertSelective(IndentInfo record);

    IndentInfo selectByPrimaryKey(Integer indentId);

    int updateByPrimaryKeySelective(IndentInfo record);

    int updateByPrimaryKey(IndentInfo record);
    List<IndentInfo> getIdentList();
    List<IndentInfo>  search(int parm);
}