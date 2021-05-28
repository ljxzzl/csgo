package com.example.demo.serviceIpl;

import com.example.demo.dao.AdminInfoDao;
import com.example.demo.dao.OrnamentInfoDao;
import com.example.demo.dao.UserInfoDao;
import com.example.demo.pojo.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.adminService;

@Service
public class adminIpl implements adminService {

@Autowired
    AdminInfoDao adminInfoDao;
@Autowired
    UserInfoDao user;
    @Autowired
    OrnamentInfoDao ornament;

    @Override
    public AdminInfo login(String account, String password) {
        return adminInfoDao.login(account,password);
    }
/*
@Autowired
    UserInfoDao user;
    @Autowired
    OrnamentInfoDao ornament;
*/






}
