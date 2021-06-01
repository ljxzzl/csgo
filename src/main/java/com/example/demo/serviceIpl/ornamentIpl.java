package com.example.demo.serviceIpl;

import com.example.demo.dao.AdminInfoDao;
import com.example.demo.dao.OrnamentInfoDao;
import com.example.demo.dao.UserInfoDao;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.service.ornamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ornamentIpl implements ornamentService {
    @Autowired
    AdminInfoDao adminInfoDao;
    @Autowired
    UserInfoDao user;
    @Autowired
    OrnamentInfoDao ornamentInfoDao;
    @Override
    public int addOrnament(OrnamentInfo ornament) {
        return ornamentInfoDao.insert(ornament);
    }

    @Override
    public List<OrnamentInfo> ornamentList() {
        return ornamentInfoDao.OrnamentList();
    }

    @Override
    public List<OrnamentInfo> qureyOrnamentList(String name) {
        return ornamentInfoDao.search(name);
    }


    @Override
    public List<OrnamentInfo> PriceOrnemntList(String name) {
        return null;
    }

    @Override
    public int close(OrnamentInfo ornamentInfo) {
        return ornamentInfoDao.updateByPrimaryKeySelective(ornamentInfo);
    }

    @Override
    public int updateByUserId(String id, String parm, String ornament_price) {
        return ornamentInfoDao.updateByUserId(id, parm, ornament_price);
    }

    @Override
    public OrnamentInfo selectByPrimaryKey(Integer ornamentId) {
        return ornamentInfoDao.selectByPrimaryKey(ornamentId);
    }

    @Override
    public List<OrnamentInfo> searchUser(String userid) {
        return ornamentInfoDao.searchUser(userid);
    }
}
