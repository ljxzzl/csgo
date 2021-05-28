package com.example.demo.controller;

import com.example.demo.Mapper.InsertToMysql;
import com.example.demo.dto.OpenIdDTO;
import com.example.demo.model.User;
import com.example.demo.provider.SteamUserProvider;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class indexController {
    @Autowired
    private SteamUserProvider steamUserProvider;
    @Autowired
    private InsertToMysql insertToMysql;

    @RequestMapping("/callback")
    public String callback(HttpServletRequest request,
                           HttpServletResponse response) {
        OpenIdDTO openIdDTO = new OpenIdDTO();
        openIdDTO.setOpenid_claimed_id(7355608  );
        openIdDTO.setOpenid_identity("//specs.openid.net/auth/2.0/identifier_select");
        openIdDTO.setOpenid_mode("checkid_setup");
        openIdDTO.setOpenid_ns("//specs.openid.net/auth/2.0");
        openIdDTO.setOpenid_realm("http://localhost:8080/callback");
        openIdDTO.setOpenid_return_to("http://localhost:8080/callback");
        String accessToken = steamUserProvider.getAccessToken(openIdDTO);
        User steamUser = steamUserProvider.getUser(accessToken);

        User user = new User();
        Integer id = openIdDTO.getOpenid_claimed_id();
        user.setId(id);
        user.setAvatar_url(openIdDTO.getOpenid_ns());
        user.setBio(openIdDTO.getOpenid_mode());
        user.setInventory("733558889665ABd");

//        insertToMysql.insert(user);

        return "product-center";

    }
}
