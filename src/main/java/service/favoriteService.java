package service;

import pojo.IndentInfo;
import pojo.OrnamentInfo;
import pojo.UserInfo;

public interface favoriteService {
    int addfavorite(OrnamentInfo ornament , UserInfo user);//添加喜欢物品信息
}
