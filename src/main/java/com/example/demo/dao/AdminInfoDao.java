package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import com.example.demo.pojo.AdminInfo;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;

import java.util.List;

@Mapper
public interface AdminInfoDao {
    int deleteByPrimaryKey(Integer adminId);//id删除

    int insert(AdminInfo record);//插入记录

    int insertSelective(AdminInfo record);//非空插入判断

    AdminInfo selectByPrimaryKey(Integer adminId);//id查找

    int updateByPrimaryKeySelective(AdminInfo record);//更新

    int updateByPrimaryKey(AdminInfo record);//非空更新判断




}