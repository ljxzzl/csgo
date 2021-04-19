package service;

import org.springframework.stereotype.Service;
import pojo.OrnamentInfo;
import pojo.UserInfo;

import java.util.List;


public interface userService {
      int register(UserInfo user); /**检测名称是否被用 并且登记
     * 返回登录用户的user信息
     *
     * @param request
     * @return
     */
      int  login (String email ,String password);
      /**
     * 返回登录用户的user信息
     *
     * @param request
     * @return
     */
     int  buyOnament(UserInfo user, OrnamentInfo ornament);/**买东西*/
     List<OrnamentInfo> ornamentList();//商品列表全部
     List<OrnamentInfo> qureyOrnamentList(String name);//搜寻商品列表全部

}
