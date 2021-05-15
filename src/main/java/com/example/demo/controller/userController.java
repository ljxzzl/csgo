package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.adminService;
import com.example.demo.service.userService;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class userController {

    @Resource
    adminService admin;
    @Resource
    userService userService;

    @PostMapping(value = "/check")
//    public ResultVO getUserList()
    public ResultVO check(@RequestParam(value = "email", required = true, defaultValue = "") String email,
                          @RequestParam(value = "name", required = true, defaultValue = "") String name) {

        Map json = new HashMap();
        ResultVO resultVO = new ResultVO();

        if (userService.check(email, name) == 0)
            resultVO.setMsg("可使用");
        else
            resultVO.setMsg("已使用");
        return resultVO;


    }

    @PostMapping(value = "/login")//返回用户信息 +显示封禁信息
//    public ResultVO getUserList()
    public ResultVO login(@RequestParam(value = "email", required = true, defaultValue = "") String email,
                          @RequestParam(value = "password", required = true, defaultValue = "") String password, HttpServletRequest request) {

        ResultVO resultVO = new ResultVO();
        Map json = new HashMap();
        UserInfo user = userService.login(email, password);
        HttpSession session = request.getSession();
        if (user != null) {
            json.put("user", user);
            resultVO.setData(json);
            resultVO.setMsg("登录");

            //第二步：将想要保存到数据存入session中
            session.setAttribute("user", user);
//            session.setAttribute("email",user.getUserEmail());
//            session.setAttribute("password",user.getUserPassword());
//            session.setAttribute("id",user.getUserId());
            //这样就完成了用户名和密码保存到session的操作
            //@Autowired
            //  HttpServletRequest request;
            /// String userName = (String) request.getSession().getAttribute("user");
            //        System.out.println(userName);
        } else
            resultVO.setMsg("未注册");
        return resultVO;

    }

    @PostMapping(value = "/register")//
//    public ResultVO getUserList()
    public ResultVO register(@RequestParam(value = "email", required = true, defaultValue = "") String email,
                             @RequestParam(value = "name", required = true, defaultValue = "") String name,
                             @RequestParam(value = "password", required = true, defaultValue = "") String password,
                             @RequestParam(value = "iphone", required = true, defaultValue = "") Integer iphone,
                             @RequestParam(value = "steam_apikey", required = true, defaultValue = "") String steam_apikey,
                             @RequestParam(value = "steam_id", required = true, defaultValue = "") String steam_id,
                             @RequestParam(value = "steam_url", required = true, defaultValue = "") String steam_url,
                             @RequestParam(value = "detail", required = true, defaultValue = "") String detail) {
        UserInfo user = new UserInfo();
        user.setUserEmail(email);
        user.setUserName(name);
        user.setUserDetail(detail);
        user.setUserIphone(iphone.toString());
        user.setUserPassword(password);
        user.setUserSteamId(steam_id);
        user.setUserSteamKey(steam_apikey);
        user.setUserUrl(steam_url);
        userService.register(user);

        ResultVO resultVO = new ResultVO();

        if (userService.register(user) > 0) {
            resultVO.setMsg("已注册");
        } else
            resultVO.setMsg("注册失败");
        return resultVO;


    }

    @PostMapping(value = "/invest")//充值另说
//    public ResultVO getUserList()
    public ResultVO invest(@RequestParam(value = "id", required = true, defaultValue = "") String id,
                           @RequestParam(value = "account", required = true, defaultValue = "") String account, HttpServletRequest request) {

        ResultVO resultVO = new ResultVO();
        HttpSession session = request.getSession();
        Map json = new HashMap();
        UserInfo user = (UserInfo) session.getAttribute("user");
        user.setUserAccount(account);//充值

        int n = userService.invest(user);
        if (n > 0) {
            session.setAttribute("user", user);
            resultVO.setMsg("已充值");
        } else {
            resultVO.setMsg("未充值");
        }


        if (user != null) {
            json.put("user", user);
            resultVO.setData(json);
        }
        return resultVO;


    }

    @PostMapping(value = "/steam_bind")//充值另说
//    public ResultVO getUserList()
    public ResultVO steam_bind(@RequestParam(value = "id", required = true, defaultValue = "") String id,
                               @RequestParam(value = "steam_apikey", required = true, defaultValue = "") String steam_apikey,
                               @RequestParam(value = "steam_id", required = true, defaultValue = "") String steam_id,
                               @RequestParam(value = "steam_url", required = true, defaultValue = "") String steam_url, HttpServletRequest request) {

        ResultVO resultVO = new ResultVO();

        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        Map json = new HashMap();
        user.setUserSteamKey(steam_apikey);
        user.setUserUrl(steam_url);
        user.setUserSteamId(steam_id);
        userService.steama_bind(user);
        int n = userService.steama_bind(user);
        if (n > 0) {
            session.setAttribute("user", user);//更新user
            resultVO.setMsg("已绑定");
        } else {
            resultVO.setMsg("未绑定");
        }

        if (user != null) {
            json.put("user", user);
            resultVO.setData(json);
        }
        return resultVO;//绑定steamapi

    }


    @GetMapping(value = "/stock_ornament")//库存
    public ResultVO stock_ornament(HttpServletRequest request) throws MalformedURLException {
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        ResultVO resultVO = new ResultVO();
        if(user.getUserSteamId()!=null)
        {
            String s=String.format("http://steamcommunity.com/profiles/%s/inventory/json/%s/%s/", user.getUserSteamId(), 730, 2);
//            String pinpointUrl="https://steamcommunity.com/profiles/76561198431360208/inventory/json/730/2";
            String json=getdata(s);
            System.out.println("开始");
            System.out.println(json);
        }



        return resultVO;

    }

    private static String getdata(String url){
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            // 设置为utf-8的编码 解决中文乱码
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

}
