package service;

import org.springframework.stereotype.Service;
import pojo.IndentInfo;
import pojo.OrnamentInfo;
import pojo.UserInfo;

public interface indentService {
    int addIndent(OrnamentInfo ornament , UserInfo user, IndentInfo indent);//添加订单信息

}
