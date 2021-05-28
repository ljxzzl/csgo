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
    OrnamentInfoDao ornament;
    @Override
    public int addOrnament(OrnamentInfo ornament) {
        return 0;
    }

    @Override
    public List<OrnamentInfo> ornamentList() {
        return ornament.OrnamentList();
    }

    @Override
    public List<OrnamentInfo> qureyOrnamentList(String name) {
        return ornament.search(name);
    }


    @Override
    public List<OrnamentInfo> PriceOrnemntList(String name) {
        return null;
    }

    @Override
    public int close(OrnamentInfo ornamentInfo) {
        return ornament.updateByPrimaryKeySelective(ornamentInfo);
    }
}
