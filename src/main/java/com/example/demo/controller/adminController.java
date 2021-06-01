package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.pojo.*;
import com.example.demo.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class adminController {
    @Resource
    adminService adminService;
    @Resource
    userService userService;
    @Resource
    ornamentService ornamentService;
    @Resource
    indentService indentService;

    @Resource
    classService reportService;
    @GetMapping(value = "/getUserList")
//    public ResultVO getUserList()
    public ResultVO getUserList() {

        Map json = new HashMap();
        ResultVO resultVO = new ResultVO();
        List<UserInfo> list = userService.getUserList();
        json.put("users", list);
        resultVO.setData(json);
        return resultVO ;
    }


    @GetMapping(value = "/getOrnamentList")
//    public ResultVO getUserList()
    public ResultVO getOrnamentList() {

        Map json = new HashMap();
        ResultVO resultVO = new ResultVO();
        List<OrnamentInfo> list =ornamentService.ornamentList();
        json.put("ornaments", list);
        resultVO.setData(json);
        /**
         * 用户列表
         */
        return resultVO ;
    }

    @PostMapping(value = "/closeUser")//只能封禁用户
//    public ResultVO getUserList()
    public ResultVO updateUserList(@RequestParam(value = "id", required = true, defaultValue = "") int id,
                               @RequestParam(value = "detail", required = true, defaultValue = "") String detail,
                       HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(id);
        userInfo.setUserDetail(detail);
        System.out.print(id+""+detail);
        userService.close(userInfo);
        if (userService.close(userInfo)!=0)
        {
            resultVO.setMsg("封禁成功");

        }

        return resultVO ;
    }
    @PostMapping(value = "/admin_login")
    public ResultVO login(@RequestParam(value = "account", required = true, defaultValue = "") String account,
                          @RequestParam(value = "password", required = true, defaultValue = "") String password, HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
        Map json = new HashMap();
         AdminInfo admin = adminService.login(account, password);
        System.out.print(admin.getAdminAccount()+"??"+admin.getAdminPassword());
         if(admin!=null){
             HttpSession session = request.getSession();
             json.put("admin", admin);
             resultVO.setData(json);
             resultVO.setCode(200);
             session.setAttribute("admin", admin);
         }

        return resultVO;

    }


    @GetMapping(value = "/getIndentList")
//    public ResultVO getUserList()
    public ResultVO getIndentList() {

        Map json = new HashMap();
        ResultVO resultVO = new ResultVO();
        List<IndentInfo> list = indentService.getIdentList();
        json.put("indent", list);
        resultVO.setData(json);
        /**
         * 用户列表
         */
        return resultVO ;

    }
    @GetMapping(value = "/getMessage")//用户人数 充值金额 成交量 当前时间展示数据
//    public ResultVO getUserList()
    public ResultVO getMessage() {
        Map json = new HashMap();
        ResultVO resultVO = new ResultVO();
        return resultVO ;
    }

    @PostMapping(value = "/user_search")//，模糊查询
    public ResultVO user_search(@RequestParam(value = "parm", required = true, defaultValue = "") String parm,
                           HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
        List<UserInfo> list=userService.search(parm);
        Map json = new HashMap();
        System.out.print(""+parm);
        json.put("queryList",list);
        resultVO.setData(json);
        return resultVO;

    }
    @PostMapping(value = "/ornament_search")//模糊查询
    public ResultVO ornament_search(@RequestParam(value = "test", required = true, defaultValue = "") String test,
                          HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
       List<OrnamentInfo> list=ornamentService.qureyOrnamentList(test);
        Map json = new HashMap();
        System.out.print(""+test);
        json.put("oList",list);
        resultVO.setData(json);
        return resultVO;

    }

    @PostMapping(value = "/closeOrnament")//只能下架商品

    public ResultVO closeOrnament(@RequestParam(value = "id", required = true, defaultValue = "") int id,
                                   @RequestParam(value = "parm", required = true, defaultValue = "") String parm,
                                   HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
       OrnamentInfo  OrnamentInfo=new  OrnamentInfo();
        OrnamentInfo.setOrnamentId(id);
        OrnamentInfo.setOrnamentStatus(parm);
        System.out.print(id+""+parm);
        ornamentService.close(OrnamentInfo);
        if ( ornamentService.close(OrnamentInfo)!=0)
        {
            resultVO.setMsg("封禁成功");
        }

        return resultVO;
    }

    @GetMapping(value = "/getReportList")
//    public ResultVO getUserList()
    public ResultVO getReportList() {

        Map json = new HashMap();
        ResultVO resultVO = new ResultVO();
         List<ClassInfo>  list=reportService.getReportList();
         json.put("reports",list);
        resultVO.setData(json);
        /**
         * 举报列表
         */
        return resultVO ;

    }

    @PostMapping(value = "/closeReport")//处理反馈受理

    public ResultVO closeReport(@RequestParam(value = "id", required = true, defaultValue = "") int id,
                                  @RequestParam(value = "parm", required = true, defaultValue = "") String parm,
                                  HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
          ClassInfo ClassInfo=new   ClassInfo ();
      ClassInfo.setClassId(id);
      ClassInfo.setClassDetial(parm);//name用来用户存放
      reportService.close(ClassInfo);
        if ( reportService.close(ClassInfo)!=0)
        {
            resultVO.setMsg("处理成功");

        }

        return resultVO;
    }



}


