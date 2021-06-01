package com.example.demo.service;

import com.example.demo.pojo.ClassInfo;

import java.util.List;

public interface classService {
    List<ClassInfo> getReportList();//全部列表
    int close(ClassInfo classInfo);

    List<ClassInfo> getUserReportList(int s);//获取用户自己的列表
    int insert(ClassInfo report);


}
