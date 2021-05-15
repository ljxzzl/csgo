package com.example.demo.dto;



public class OpenIdDTO {
    private String openid_ns;
    private String openid_mode;
    private String openid_return_to;
    private String openid_realm;
    private Integer openid_claimed_id;


    public String getOpenid_ns() {
        return openid_ns;
    }

    public void setOpenid_ns(String openid_ns) {
        this.openid_ns = openid_ns;
    }

    public String getOpenid_mode() {
        return openid_mode;
    }

    public void setOpenid_mode(String openid_mode) {
        this.openid_mode = openid_mode;
    }

    public String getOpenid_return_to() {
        return openid_return_to;
    }

    public void setOpenid_return_to(String openid_return_to) {
        this.openid_return_to = openid_return_to;
    }

    public String getOpenid_realm() {
        return openid_realm;
    }

    public void setOpenid_realm(String openid_realm) {
        this.openid_realm = openid_realm;
    }

    public Integer getOpenid_claimed_id() {
        return openid_claimed_id;
    }

    public void setOpenid_claimed_id(Integer openid_claimed_id) {
        this.openid_claimed_id = openid_claimed_id;
    }

    public String getOpenid_identity() {
        return openid_identity;
    }

    public void setOpenid_identity(String openid_identity) {
        this.openid_identity = openid_identity;
    }

    private String openid_identity;
}
