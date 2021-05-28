package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class User {
    private String username;
    private String password;
    private String SteamID;
    private String SteamUrl;


}
