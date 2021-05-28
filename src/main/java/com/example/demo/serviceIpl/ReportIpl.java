package com.example.demo.serviceIpl;

import com.example.demo.dao.ClassInfoDao;
import com.example.demo.pojo.ClassInfo;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.classService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportIpl implements classService {
    @Autowired
    ClassInfoDao reportDao;
    @Override

    public List<ClassInfo> getReportList() {
        return reportDao.getReportList();
    }

    @Override
    public int close(ClassInfo classInfo) {
        return  reportDao.updateByPrimaryKey(classInfo);
    }


}
