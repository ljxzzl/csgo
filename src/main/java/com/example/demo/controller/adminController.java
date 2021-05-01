package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.service.userService;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.adminService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class adminController {
    @Resource
    adminService admin;
    @Resource
    userService user;
    @GetMapping(value = "/getUseList")
//    public ResultVO getUserList()
    public ResultVO getUserList() {

        Map json = new HashMap();
        ResultVO resultVO = new ResultVO();
        List<UserInfo> list = user.getUserList();
        json.put("users", list);
        resultVO.setData(json);
        /**
         * 用户列表
         */
        return resultVO ;
    }

}
