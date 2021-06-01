package com.example.demo;

import com.example.demo.model.rgInventory;
import com.example.demo.provider.rgProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    com.example.demo.provider.rgProvider rgProvider;
    @Test
    void contextLoads() throws IOException {

    }

}
