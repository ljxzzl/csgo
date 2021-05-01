package com.example.demo.provider;

import com.alibaba.fastjson.JSON;
import com.example.demo.dto.OpenIdDTO;
import com.example.demo.model.User;
import okhttp3.*;
import org.springframework.stereotype.Component;

@Component
public class SteamUserProvider {
    public String getAccessToken(OpenIdDTO openId) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(openId));
        Request request = new Request.Builder()
                .url("https://partner.steam-api.com/IInventoryService/AddItem/v1/")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        } catch (Exception e) {

        }
        return null;
    }


    public User getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://partner.steam-api.com/IInventoryService/AddPromoItem/v1/")
                .header("Authorization", "token " + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            User user = JSON.parseObject(string, User.class);
            user.setInventory(string);
            return user;
        } catch (Exception e) {

        }
        return null;
    }


}
