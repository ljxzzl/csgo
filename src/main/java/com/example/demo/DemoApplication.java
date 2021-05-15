package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.print("http://localhost:8080/userPage/user_index.html\n");
        System.out.print("http://localhost:8080/accountPage/index.html\n");

        System.out.print("http://localhost:8080/accountPage/login.html\n");
        try {
            urltest();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static  void urltest() throws IOException {

        String s=String.format("http://steamcommunity.com/profiles/%s/inventory/json/%s/%s/\n","76561198431360208", "730","2" );
        System.out.print(s+"\n");





    }
    }
























