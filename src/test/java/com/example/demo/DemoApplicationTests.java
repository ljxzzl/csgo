package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.rgInventory;
import com.example.demo.provider.rgProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    com.example.demo.provider.rgProvider rgProvider;

}
