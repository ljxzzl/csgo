package com.example.demo.dao;

import com.example.demo.pojo.ClassInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassInfoDao {
    int deleteByPrimaryKey(Integer classId);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
}