package controller;

import VO.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pojo.UserInfo;
import service.adminService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class adminController {
    @Resource
    adminService admin;
    @GetMapping(value = "/getUseList")
//    public ResultVO getUserList()
    public ResultVO getUserList() {

        Map json = new HashMap();
        ResultVO resultVO = new ResultVO();
        List<UserInfo> list = admin.List();
        json.put("users", list);
        resultVO.setData(json);
        /**
         * 用户列表
         */
        return resultVO ;
    }

}
