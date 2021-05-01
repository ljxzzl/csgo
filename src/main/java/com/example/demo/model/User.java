package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private Integer id;
    private String bio;
    private String avatar_url;
    private String inventory;

}
