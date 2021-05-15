package com.example.demo.serviceIpl;

import com.example.demo.dao.UserInfoDao;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userIpl implements userService {
@Autowired
    UserInfoDao userdao;

    @Override
    public int register(UserInfo user) {

        return userdao.insert(user);
    }

    @Override
    public UserInfo login(String email, String password) {
        return userdao.login(email, password);
    }

    @Override
    public int buyOnament(UserInfo user, OrnamentInfo ornament) {
        return userdao.buyOnament(user, ornament);
    }

    @Override
    public int steama_bind(UserInfo user) {
        return userdao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int invest(UserInfo user) {
        return userdao.updateByPrimaryKeySelective(user);
    }


    @Override
    public List<UserInfo> getUserList() {
        return userdao.getUserList();
    }

    @Override
    public int check(String name, String email) {
        return userdao.check(name, email);
    }

    @Override
    public int stock_ornament(UserInfo user) {
        return 0;
    }

    @Override
    public int close(UserInfo user) {
        return userdao.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<UserInfo> search(String parm) {
        return userdao.search(parm);
    }

}

