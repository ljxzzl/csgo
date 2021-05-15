package com.example.demo.service;

import com.example.demo.pojo.ClassInfo;

import java.util.List;

public interface classService {
    List<ClassInfo> getReportList();
    int close(ClassInfo classInfo);

}
