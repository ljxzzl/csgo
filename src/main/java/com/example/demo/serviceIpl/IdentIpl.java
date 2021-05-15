package com.example.demo.serviceIpl;

import com.example.demo.dao.AdminInfoDao;
import com.example.demo.dao.IndentInfoDao;
import com.example.demo.dao.OrnamentInfoDao;
import com.example.demo.dao.UserInfoDao;
import com.example.demo.pojo.IndentInfo;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.indentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IdentIpl implements indentService {
    @Autowired
    IndentInfoDao indentInfoDao;
    @Autowired
    UserInfoDao user;
    @Autowired
    OrnamentInfoDao ornament;
    @Override
    public int addIndent(OrnamentInfo ornament, UserInfo user, IndentInfo indent) {
        return 0;
    }

    @Override
    public List<IndentInfo> getIdentList() {
        return  indentInfoDao.getIdentList();
    }
}
