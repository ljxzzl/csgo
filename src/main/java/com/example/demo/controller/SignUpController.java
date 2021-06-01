package com.example.demo.controller;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {
    @Autowired
    Admin admin;
    @Autowired
    AdminMapper adminMapper;
    @PostMapping("/SignUpAdmin")
    public String InsertAdmin(HttpServletRequest request,
                              HttpServletResponse response,
                              @RequestParam(value = "account",required = false) String account,
                              @RequestParam(value = "password",required = false) String password,
                              Model model){
        model.addAttribute("account",account);
        model.addAttribute("password",password);

        admin.setAccount(account);
        admin.setPassword(password);
        adminMapper.InsertAdmin(admin);
        return "adminIndex";
    }
}
