
package com.example.demo.controller;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.example.demo.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
public class OrderController {
    @PostMapping("/oalipay")
    public String alipay(String out_trade_no,String subject,String total_amount,String body,String product_code) throws AlipayApiException {
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
        model.setOutTradeNo(UUID.randomUUID().toString());//商品id
        model.setBody(body);//商品描述
        model.setSubject(subject);//商品名称
        model.setTimeoutExpress("30m");//超市
        model.setTotalAmount(total_amount);//支付金额
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        //设置request参数
        request.setBizModel(model);
        /*alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");*/

        //生成表单
        AlipayTradePagePayResponse alipayTradePagePayResponse = alipayClient.pageExecute(request);
        String result = alipayTradePagePayResponse.getBody();

        return result;
    }

}
