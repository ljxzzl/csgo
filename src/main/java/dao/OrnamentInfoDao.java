package dao;

import pojo.OrnamentInfo;

public interface OrnamentInfoDao {
    int deleteByPrimaryKey(Integer ornamentId);

    int insert(OrnamentInfo record);

    int insertSelective(OrnamentInfo record);

    OrnamentInfo selectByPrimaryKey(Integer ornamentId);

    int updateByPrimaryKeySelective(OrnamentInfo record);

    int updateByPrimaryKey(OrnamentInfo record);
}