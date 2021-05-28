package com.example.demo.service;

import com.example.demo.pojo.IndentInfo;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;

import java.util.List;

public interface indentService {
    int addIndent(OrnamentInfo ornament , UserInfo user, IndentInfo indent);//添加订单信息
    List<IndentInfo> getIdentList();
}
