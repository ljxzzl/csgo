package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pojo.AdminInfo;
import pojo.OrnamentInfo;
import pojo.UserInfo;

import java.util.List;

@Mapper
public interface AdminInfoDao {
    int deleteByPrimaryKey(Integer adminId);//id删除

    int insert(AdminInfo record);//插入记录

    int insertSelective(AdminInfo record);//非空插入判断

    AdminInfo selectByPrimaryKey(Integer adminId);//id查找

    int updateByPrimaryKeySelective(AdminInfo record);//更新

    int updateByPrimaryKey(AdminInfo record);//非空更新判断

    @Select("select * from user_info")
    List<UserInfo> List();

    @Select("select * from ornament_info")
    List<OrnamentInfo> OrnamentList();
    @Select("select * from account_info where admin_account=#{account} and admin_password=#{password} ")
    int  login (String account ,String password);



}