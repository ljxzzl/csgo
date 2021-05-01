package com.example.demo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
public class OpenIdDTO {
    private String openid_ns;
    private String openid_mode;
    private String openid_return_to;
    private String openid_realm;
    private Integer openid_claimed_id;
    private String openid_identity;
}
