package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class indexController {

        @Autowired
        UserMapper userMapper;
        @GetMapping("/callback")
        public String callback(HttpServletRequest request,
                               HttpServletResponse response) {
                return "index";

        }
        @PostMapping("/index")
        public String returnIndex(HttpServletRequest request,
                                  HttpServletResponse response,
                                  @RequestParam(value = "userName",required = false) String userName,
                                  @RequestParam(value = "password",required = false) String password,
                                  @RequestParam(value = "SteamID",required = false) String SteamID,
                                  @RequestParam(value = "SteamUrl",required = false) String SteamUrl,
                                  Model model){
                model.addAttribute("userName",userName);
                model.addAttribute("password",password);
                model.addAttribute("SteamID",SteamID);
                model.addAttribute("SteamUrl",SteamUrl);

                if (userName==null||userName==""){
                        model.addAttribute("error","用户名不能为空");
                        return "SignUp";
                }
                if (password==null||password==""){
                        model.addAttribute("error","密码不能为空");
                        return "SignUp";
                }
                if (SteamID==null||SteamID==""){
                        model.addAttribute("error","SteamID不能为空");
                        return "SignUp";
                }
                if (SteamUrl==null||SteamUrl==""){

                        model.addAttribute("error","SteamUrl不能为空");
                        return "SignUp";
                }
//                User user = null;
//                Cookie[] cookies = request.getCookies();
//                if (cookies!=null&&cookies.length==0){
//                        for (Cookie cookie : cookies) {
//                                if (cookie.getName().equals("SteamID")){
//                                        String steamId = cookie.getValue();
//                                        user = userMapper.findById(steamId);
//                                        if (user!=null){
//                                              request.getSession().setAttribute("user",user);
//                                        }
//                                        break;
//                                }
//                        }
//                }
//                if (user == null){
//                        model.addAttribute("error","用户未登陆");
//                        return "index";
//                }
                User user = new User();
//                user.setUsername(userName);
//                user.setPassword(password);
//                user.setSteamID(SteamID);
//                user.setSteamUrl(SteamUrl);
//                userMapper.insert(user);
                return "index";
        }
}