package com.example.demo.mapper;


import com.example.demo.model.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface AdminMapper {
    @Insert("insert into admin_info (admin_account,admin_password) values (#{account},#{password})")
    void InsertAdmin(Admin admin);
}
