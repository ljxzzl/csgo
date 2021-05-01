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
    public int login(String email, String password) {
        return userdao.login(email, password);
    }

    @Override
    public int buyOnament(UserInfo user, OrnamentInfo ornament) {
        return userdao.buyOnament(user, ornament);
    }

    @Override
    public int steama_bind(String steam_id, String apikey,String url) {
        return userdao.steama_bind(steam_id, apikey, url);
    }

    @Override
    public int invest(int id, String money) {
        return userdao.invest(id, money);
    }

    @Override
    public List<UserInfo> getUserList() {
        return userdao.getUserList();
    }

    @Override
    public int check(String name, String email) {
        return userdao.check(name, email);
    }
}

