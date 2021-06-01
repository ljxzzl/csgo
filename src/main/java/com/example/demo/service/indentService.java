package com.example.demo.service;

import com.example.demo.pojo.ClassInfo;
import com.example.demo.pojo.IndentInfo;
import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.pojo.UserInfo;

import java.util.List;

public interface indentService {
    int addIndent( IndentInfo indent);//添加订单信息
    List<IndentInfo> getIdentList();
    List<IndentInfo> getUserIndentList(int s);//获取用户自己的列表






}
