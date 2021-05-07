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
        String url = "https://steamcommunity.com/openid/login?" +
                "openid.claimed_id=http://specs.openid.net/auth/2.0/identifier_select&" +
                "openid.identity=http://specs.openid.net/auth/2.0/identifier_select&" +
                "openid.mode=checkid_setup&" +
                "openid.ns=http://specs.openid.net/auth/2.0&" +
                "openid.realm=https://" + "csgo"+ "&" +
                "openid.return_to=https://" + "localhost:8080/userPage/user_index.html" + "/signin/";
        System.out.print(url+"\n");
        try {
            urltest();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static  void urltest() throws IOException {

        String s=String.format("http://steamcommunity.com/profiles/%s/inventory/json/%s/%s/\n","76561198431360208", "730","2" );
        System.out.print(s+"\n");
        System.out.print( getJsonContent(s));
    }
    public static String getJsonContent(String urlStr) {
        try {
            // obtain HttpURLConnection Object
            URL url = new URL(urlStr);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            httpCon.setConnectTimeout(3000);
            httpCon.setDoInput(true);
            httpCon.setRequestMethod("GET");

            // 获取相应码
            int respCode = httpCon.getResponseCode();
            if (respCode == 200) {
                return ConvertStream2Json(httpCon.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String ConvertStream2Json(InputStream inputStream) {
        String jsonStr = "";
        // ByteArrayOutputStream相当于内存输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        // 将输入流转移到内存输出流中
        try {
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, len);
            }
            // 将内存流转换为字符串
            jsonStr = new String(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }





















}
