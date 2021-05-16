package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class indexController {

    @RequestMapping("/callback")
    public String callback(HttpServletRequest request,
                           HttpServletResponse response) {
        return "product-center.html";

    }
}
