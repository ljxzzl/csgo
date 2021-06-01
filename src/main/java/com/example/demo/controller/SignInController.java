package com.example.demo.controller;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignInController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/SignIn")
    public String SignInController(){
        return "SignIn";
    }
    @PostMapping("/SignIn")
    public String SignIn(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "userName",required = false) String userName,
            @RequestParam(value = "password",required = false) String password,
            Model model
    ){
        model.addAttribute("userName",userName);
        model.addAttribute("password",password);
        if (userName==null||userName==""){
            model.addAttribute("error","用户名不能为空");
            return "SignUp";
        }
        if (password==null||password==""){
            model.addAttribute("error","密码不能为空");
            return "SignUp";
        }
        User user = userMapper.findByPwd(password);
        User byUserName = userMapper.findByUserName(userName);
        if (user!=null&&byUserName!=null&&user.equals(byUserName)){
            model.addAttribute("msg","登录成功");
            response.addCookie(new Cookie("userName",userName));
            return "index";
        }
        else {
            model.addAttribute("msg","登陆失败！");
            return "SignIn";
        }

    }
}
