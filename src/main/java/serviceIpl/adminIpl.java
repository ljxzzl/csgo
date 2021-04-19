package serviceIpl;

import dao.AdminInfoDao;
import dao.OrnamentInfoDao;
import dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.OrnamentInfo;
import pojo.UserInfo;
import service.adminService;

import java.util.List;

@Service
public class adminIpl implements adminService {

@Autowired
    AdminInfoDao admin;
/*
@Autowired
    UserInfoDao user;
    @Autowired
    OrnamentInfoDao ornament;
*/


    @Override
    public int login(String account, String password) {
        return admin.login(account, password);
        //登录
    }

    @Override
    public List<UserInfo> List() {
        return admin.List();//用户
    }

    @Override
    public List<OrnamentInfo> OrnamentList() {
        return admin.OrnamentList();//全部商品
    }


}
