package com.example.demo.provider;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.rgInventory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class rgProvider {
    public rgInventory GetInventory() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://steamcommunity.com/profiles/76561198131919884/inventory/json/730/2")
                .build();
        Response response = client.newCall(request).execute();
        String string = response.body().string();
        rgInventory rgInventory = JSON.parseObject(string, rgInventory.class);
        return rgInventory;
    }


}
