package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.example.demo.VO.ResultVO;
import com.example.demo.pojo.*;
import com.example.demo.service.*;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.scope.ClassScope;
import com.example.demo.config.AlipayConfig;
import javax.annotation.Resource;
import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.*;

@RestController
public class userController {

    @Resource
    adminService admin1;
    @Resource
    userService userService;
    @Resource
    classService reportService;
    @Resource
    favoriteService  favoriteService;
    @Resource
    indentService  indentService;
    @Resource
    ornamentService     ornamentService;

    @PostMapping(value = "/check")//检查重复名称
//    public ResultVO getUserList()
    public ResultVO check(@RequestParam(value = "email", required = true, defaultValue = "") String email,
                          @RequestParam(value = "name", required = true, defaultValue = "") String name) {
        Map json = new HashMap();
        ResultVO resultVO = new ResultVO();

        if (userService.check(email, name) == 0)
        { resultVO.setMsg("可使用");}
        else
        { resultVO.setMsg("已使用");}
        return resultVO;
    }

    @PostMapping(value = "/login")//登录+返回用户信息 +显示封禁信息
//    public ResultVO getUserList()
    public ResultVO login(@RequestParam(value = "email", required = true, defaultValue = "") String email,
                          @RequestParam(value = "password", required = true, defaultValue = "") String password, HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
        Map json = new HashMap();
        System.out.print(email+""+password);
        UserInfo user = userService.login(email, password);
        if (user != null) {
            json.put("user", user);
            resultVO.setData(json);
            resultVO.setMsg("登录");
            //第二步：将想要保存到数据存入session中
        } else

            resultVO.setMsg("未注册");
        return resultVO;
    }

    @PostMapping(value = "/register")//注册
//    public ResultVO getUserList()
    public ResultVO register(@RequestParam(value = "email", required = true, defaultValue = "") String email,
                             @RequestParam(value = "name", required = true, defaultValue = "") String name,
                             @RequestParam(value = "password", required = true, defaultValue = "") String password,
                             @RequestParam(value = "iphone", required = true, defaultValue = "") String iphone
//                             @RequestParam(value = "steam_apikey", required = true, defaultValue = "") String steam_apikey,
//                             @RequestParam(value = "steam_id", required = true, defaultValue = "") String steam_id,
//                             @RequestParam(value = "steam_url", required = true, defaultValue = "") String steam_url
                          ) {
        UserInfo user = new UserInfo();
        user.setUserEmail(email);
        user.setUserName(name);
        user.setUserIphone(iphone);
        user.setUserPassword(password);
        user.setUserAccount("0");
//        user.setUserSteamKey(steam_apikey);
//        user.setUserUrl(steam_url);
        userService.register(user);
        System.out.print(user);
        ResultVO resultVO = new ResultVO();

        if (userService.register(user) > 0) {
            resultVO.setMsg("已注册");
        } else
            resultVO.setMsg("注册失败");
        return resultVO;


    }

    @PostMapping(value = "/invest",produces = "text/html;charset=UTF-8")//充值账号
//    public ResultVO getUserList()
    public String  invest(@RequestParam(value = "userid", required = true, defaultValue = "") Integer userid,
                           @RequestParam(value = "account", required = true, defaultValue = "") String account) throws AlipayApiException {
       System.out.print("id"+userid+"充值金额"+account+"\n");
        ResultVO resultVO = new ResultVO();
        Map json = new HashMap();
        UserInfo user1= userService.selectByPrimaryKey(userid);
        String s = user1.getUserAccount();
        BigDecimal num1 = new BigDecimal(s);
        BigDecimal num2 = new BigDecimal(account);
        BigDecimal add = num1.add(num2);
        UserInfo user =  new UserInfo();
        user.setUserId(userid);
        user.setUserAccount(add.toString());
        //充值
        AlipayConfig alipayConfig = new AlipayConfig();
        //封装RSA签名方式
        AlipayClient alipayClient = new DefaultAlipayClient(
                alipayConfig.URL,//请求网关
                alipayConfig.APPID,//收款ID
                alipayConfig.RSA_PRIVATE_KEY,//私钥
                alipayConfig.FORMAT,//返回格式
                alipayConfig.CHARSET,//字符编码格式
                alipayConfig.ALIPAY_PUBLIC_KEY,//支付宝公钥
                alipayConfig.SIGNTYPE);//加密方式
        //创建request
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //设置异步回调地址
        request.setNotifyUrl(alipayConfig.notify_url);
        //设置同步回调地址
        request.setReturnUrl(alipayConfig.return_url);
        //封装参数
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo("100342312764512");//商品id
        model.setBody("cs商品");//商品描述
        model.setSubject("cs商品");//商品名称
        model.setTimeoutExpress("30m");//超市
        model.setTotalAmount(account);//支付金额
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        //设置request参数
        request.setBizModel(model);
        AlipayTradePagePayResponse alipayTradePagePayResponse = alipayClient.pageExecute(request);
        String result = alipayTradePagePayResponse.getBody();
        int n = userService.invest(user);
        if (n > 0) {
            resultVO.setData(result);
            resultVO.setMsg("已充值");
        } else {
            resultVO.setMsg("未充值");
        }
        if (user!= null) {
            json.put("user", user);
            resultVO.setData(json);
        }
        return result;

    }

    @PostMapping(value = "/steam_bind")//steam绑定64为id partnerid
//    public ResultVO getUserList()
    public ResultVO steam_bind(@RequestParam(value = "userid", required = true, defaultValue = "") Integer userid,
                               @RequestParam(value = "steamapikey", required = true, defaultValue = "") String steamapikey,
                               @RequestParam(value = "steamid", required = true, defaultValue = "") String steamid,
                               @RequestParam(value = "steamurl", required = true, defaultValue = "") String steamurl) {
        ResultVO resultVO = new ResultVO();
        UserInfo user = new     UserInfo();
        Map json = new HashMap();
        System.out.print("steamid"+userid+steamapikey);
        user.setUserSteamKey(steamapikey);
        user.setUserUrl(steamurl);
        user.setUserSteamId(steamid);
        user.setUserId(userid);
        userService.steama_bind(user);
        int n = userService.steama_bind(user);
        if (n > 0) {
            resultVO.setMsg("已绑定");
        } else {
            resultVO.setMsg("未绑定");
        }

        if (user != null) {
            json.put("user", user);
            resultVO.setData(json);
        }
        return resultVO;//绑定steamapi

    }

    @PostMapping (value = "/stock_ornament")//检测库存+到数据库
    public ResultVO stock_ornament(@RequestParam(value = "userid", required = true, defaultValue = "") Integer userid
                                   ) throws MalformedURLException {
        UserInfo user = (UserInfo) userService.selectByPrimaryKey(userid);
        System.out.print("检视库存啊"+user.getUserSteamId());
        ResultVO resultVO = new ResultVO();

        if(user.getUserSteamId()!=null)
        {
            String str=String.format("https://steamcommunity.com/profiles/76561198426420437/inventory/json/730/2");

            System.out.println(str);
            String json=getdata(str);
            System.out.println("stock");
            System.out.println(json);
            //System.out.println(content);
            JSONObject jsonObject = JSONObject.parseObject(json);
            //System.out.println(jsonObject);
            JSONObject rgDescriptions =(JSONObject) jsonObject.get("rgDescriptions");
            //System.out.println(rgDescriptions);
            Set<String> set = rgDescriptions.keySet();//使用迭代器
            //System.out.println(set);
            OrnamentInfo ornamentInfo=new OrnamentInfo();
            for (String s : set) {
                JSONObject o = (JSONObject) rgDescriptions.get(s);
                String name = (String) o.get("name");
                String type = (String) o.get("type");
                String icon_url = (String) o.get("icon_url");
                System.out.println(name);
                System.out.println(type);
                System.out.println(icon_url);
                System.out.println();
                ornamentInfo.setOrnamentName(name);
                ornamentInfo.setOrnamentClass(type);
                String image="http://steamcommunity-a.akamaihd.net/economy/image/"+icon_url;
                ornamentInfo.setOrnamentImage(image);
                ornamentInfo.setOrnamentCount(userid.toString());
                ornamentInfo.setOrnamentStatus("用户库存中");
                ornamentService.addOrnament(ornamentInfo);
            }
            List< OrnamentInfo> list= ornamentService.searchUser(userid.toString());//用户饰品列表
            Map steam = new HashMap();
            steam.put("steamOrnamentlist",list);
            resultVO.setData(json);
            resultVO.setMsg("检测到用户的库存");

        }else{
            resultVO.setMsg("未绑定");
        }



        return resultVO;

    }

    private static String getdata(String url){//json转换
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            // 设置为utf-8的编码 解决中文乱码
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    @PostMapping(value = "/creatOrder")//创建订单+查看自己的订单

    public ResultVO creatOrder(
                             @RequestParam(value = "creatTime", required = true, defaultValue = "") String creatTime,
                             @RequestParam(value = "ornament_id", required = true, defaultValue = "") Integer ornament_id,
                             @RequestParam(value = "user1_id", required = true, defaultValue = "") Integer user1_id,
                             @RequestParam(value = "user2_id", required = true, defaultValue = "") Integer user2_id,
                             @RequestParam(value = "detail", required = true, defaultValue = "") String detail

    ) {
        ResultVO resultVO = new ResultVO();
       IndentInfo indent=new IndentInfo();
       indent.setIndentCreattime(creatTime);
        indent.setIndentOrnamentId(ornament_id);
        indent.setIndentUser1Id(user1_id);
        indent.setIndentUser2Id(user2_id);
        indent.setIndentDetail(detail);
        indentService.addIndent(indent);

        return resultVO;


    }
    @PostMapping(value = "/lookMessage")//订单交易举报
    public ResultVO lookMessage(@RequestParam(value = "userid", required = true, defaultValue = "") Integer userid) {
        ResultVO resultVO = new ResultVO();
        System.out.print(userid+"测试·");
        List<IndentInfo> list1=  indentService.getUserIndentList(userid);//获取订单列表+list1需要一些对方用户信息+饰品名称

        List<FavoriteInfo> list2= favoriteService.getUserFavoriteList(userid);//喜欢列表+ LIST2需要一些饰品信息
        String s="用户id="+userid;
        System.out.print(s);
        List<ClassInfo> list3= reportService.getUserReportList(userid);//查看三个信息

        List<UserInfo> list4= new ArrayList<UserInfo>();
        List< OrnamentInfo> list5= new ArrayList<OrnamentInfo>();
        List< OrnamentInfo> list6= new ArrayList<OrnamentInfo>();
        UserInfo user=new  UserInfo();
        OrnamentInfo oranment=new   OrnamentInfo();
        for(int n=0;n<list1.size();n++)
  {
 user=userService.selectByPrimaryKey(list1.get(n).getIndentUser2Id());
 list4.add(user);
 oranment=ornamentService.selectByPrimaryKey(list1.get(n).getIndentOrnamentId());
 list5.add(oranment);
}
        for(int n=0;n<list2.size();n++)
        {
            oranment=ornamentService.selectByPrimaryKey(list2.get(n).getFavoriteOrnamentId());
            list6.add(oranment);
        }


        Map json = new HashMap();
        json.put("list3",list3);//举报相关
        json.put("list4",list4);//交易相关用户+dingdan
        json.put("list5",list5);//交易相关饰品+dingdan
        json.put("list6",list6);//所喜爱的饰品信息
        resultVO.setData(json);
        System.out.print(list3.toArray().toString());


        return resultVO;


    }




    @PostMapping(value = "/userreport")//举报反馈

    public ResultVO userreport(   @RequestParam(value = "userid", required = true, defaultValue = "") int userid,
                                   @RequestParam(value = "reportname", required = true, defaultValue = "") String reportname

    ) {
        ResultVO resultVO = new ResultVO();
        ClassInfo ClassInfo=new   ClassInfo ();
        String s="userid="+userid;
        ClassInfo.setClassName(s+""+reportname);
        ClassInfo.setClassUserId(userid);
        //插入加返回举报列表中模糊查询的userid=?
        System.out.print(s+reportname);
        int n=reportService.insert(ClassInfo);
        if(n!=0)
        {
            resultVO.setMsg("添加反馈");

        }
        else{
            resultVO.setMsg("添加失败");
        }
        return resultVO;

    }


    @PostMapping(value = "/addFavorite")//添加喜欢+查看自己的喜欢

    public ResultVO addFavorite(@RequestParam(value = "ornamentid", required = true, defaultValue = "") Integer ornamentid,
                           @RequestParam(value = "userid", required = true, defaultValue = "") Integer userid,
                           @RequestParam(value = "detail", required = true, defaultValue = "")  String  detail

    ) {

        ResultVO resultVO = new ResultVO();////插入喜欢列表中模糊查询的userid=?
        FavoriteInfo favoriteInfo=new FavoriteInfo();
        favoriteInfo.setFavoriteOrnamentId(ornamentid);
        favoriteInfo.setFavoriteUserId(userid);
        favoriteInfo.setFavoriteDetail(detail);
     int n=favoriteService.addfavorite(favoriteInfo);
     if(n!=0)
     {
         resultVO.setMsg("添加收藏夹");

     }
     else{
         resultVO.setMsg("添加失败");
     }
         return resultVO;


    }

    @GetMapping (value = "/ornament_sell")//在售商品
    public ResultVO ornament_sell() {
        ResultVO resultVO = new ResultVO();
        List<OrnamentInfo> list=ornamentService.qureyOrnamentList("在售");
        Map json = new HashMap();
        json.put("sellList",list);
        resultVO.setData(json);
        return resultVO;
    }

    @PostMapping(value = "/userornament")//用户所有商品/
    public ResultVO userornament(@RequestParam(value = "userid", required = true, defaultValue = "")String userid
                                  ) {
        ResultVO resultVO = new ResultVO();

        List< OrnamentInfo> list= ornamentService.searchUser(userid);//用户饰品列表
        Map json = new HashMap();
        json.put("userOrnamentlist",list);

        resultVO.setData(json);

        return resultVO;
    }
    @PostMapping(value = "/updateuserornament")//用户更改商品/
    public ResultVO updateOrnament(@RequestParam(value = "ornamentid", required = true, defaultValue = "")int ornamentid,
                                   @RequestParam(value = "status", required = true, defaultValue = "") String status,
                                   @RequestParam(value = "price", required = true, defaultValue = "") String price
                                   ) {
        ResultVO resultVO = new ResultVO();
     OrnamentInfo ornamentInfo=new OrnamentInfo();
     System.out.print("用户更改商品"+status);
     ornamentInfo.setOrnamentId(ornamentid);
     ornamentInfo.setOrnamentStatus(status);
     ornamentInfo.setOrnamentPrice(price);
     int n=ornamentService.close(ornamentInfo);
        if ( n!=0 )
        {
            resultVO.setMsg("更改成功");
        }
        else
        {
            resultVO.setMsg("更改失败");
        }

        return resultVO;
    }

    @PostMapping(value = "/lookornament")//用户更改商品/
    public ResultVO lookornament(@RequestParam(value = "ornamentid", required = true, defaultValue = "")int ornamentid
    ) {
        ResultVO resultVO = new ResultVO();
        System.out.print("ornamentid"+ornamentid);
        OrnamentInfo ornamentInfo=ornamentService.selectByPrimaryKey(ornamentid);
        Map json = new HashMap();
        json.put("OrnamentDetail",ornamentInfo);
        if ( ornamentInfo!=null )
        {  resultVO.setData(json);
            resultVO.setMsg("更改成功");
        }
        else
        {
            resultVO.setMsg("更改失败");
        }

        return resultVO;
    }


    @PostMapping(value = "/exchange")//交易
    public ResultVO exchange(@RequestParam(value = "ornamentid", required = true, defaultValue = "")int ornamentid) {
        ResultVO resultVO = new ResultVO();
        System.out.print("ornamentid测试数据"+ornamentid);
        OrnamentInfo ornamentInfo=ornamentService.selectByPrimaryKey(ornamentid);
        UserInfo     UserInfo= userService.selectByPrimaryKey(Integer.parseInt(ornamentInfo.getOrnamentCount()));
        Map json = new HashMap();
        json.put("OrnamentChange",ornamentInfo);
        json.put("UserDetail",UserInfo);
        if ( ornamentInfo!=null )
        {  resultVO.setData(json);
            resultVO.setMsg("点击交易");
        }
        else
        {
            resultVO.setMsg("交易失败");
        }

        return resultVO;
    }


}
