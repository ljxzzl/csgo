package service;

import org.springframework.stereotype.Service;
import pojo.ClassInfo;
import pojo.OrnamentInfo;
import pojo.UserInfo;

public interface classService {
    int addClass(ClassInfo classInfo);//添加喜欢物品信息
}
