package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.OrnamentInfo;
import com.sun.deploy.net.HttpResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {
    private static String getdata(String url){//json转换
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
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.print("http://localhost:8080/userPage/user_index.html\n");
        System.out.print("http://localhost:8080/accountPage/index.html\n");
        System.out.print("http://localhost:8080/accountPage/login.html\n");


        String str=String.format("https://steamcommunity.com/profiles/76561198131919884/inventory/json/730/2");
        String json=getdata(str);

            String content = json;

            JSONObject jsonObject = JSONObject.parseObject(content);
            //System.out.println(jsonObject);
            JSONObject rgDescriptions =(JSONObject) jsonObject.get("rgDescriptions");
            //System.out.println(rgDescriptions);
            Set<String> set = rgDescriptions.keySet();//使用迭代器
            //System.out.println(set);
            for (String s : set) {
                JSONObject o = (JSONObject) rgDescriptions.get(s);
                String name = (String) o.get("name");
                String type = (String) o.get("type");
//                String icon_url = (String) o.get("icon_url");
//                System.out.println(name);
//                System.out.println(type);
//                System.out.println(icon_url);
//                System.out.println();
            }




//        String str=String.format("http://steamcommunity.com/profiles/%s/inventory/json/%s/%s","76561198431360208", 730, 2);
//        System.out.print(str);
    }






    }
























