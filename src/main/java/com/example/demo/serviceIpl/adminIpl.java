package com.example.demo.serviceIpl;

import com.example.demo.dao.AdminInfoDao;
import com.example.demo.dao.OrnamentInfoDao;
import com.example.demo.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.adminService;

import java.util.List;

@Service
public class adminIpl implements adminService {

@Autowired
    AdminInfoDao admin;
@Autowired
    UserInfoDao user;
    @Autowired
    OrnamentInfoDao ornament;
/*
@Autowired
    UserInfoDao user;
    @Autowired
    OrnamentInfoDao ornament;
*/


    @Override
    public int login(String account, String password) {
        return Integer.parseInt(null);
        //登录
    }



}
