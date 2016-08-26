package com.gonali.qiaokebao.utils.authorityCode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gonali.qiaokebao.utils.ConfigUtils;
import com.gonali.qiaokebao.utils.HttpClientUtils;

import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/8/26.

 短信API：
 天翼-电信
 http://open.189.cn/show-6-88-1.html
 账号:goanli@aliyun.com
 密码:大劈机耳猛爱特鸡呕嗯叉叉点卡盟

 */
public class SendSmsAuthCode {

    private static String SMS_APP_ID = "279571240000256451";//应用ID------登录平台在应用设置可以找到
    private static String SMS_APP_SECRET = "e9c8c5bcfbfb3ca77bdde023940dc763";//应用secret-----登录平台在应用设置可以找到
    private static String SMS_SEND_API = "";
    private static String SMS_ACCESS_TOKEN_API = "";
    private static String SMS_TOKEN_API = "";

    private String ACCESS_TOKEN = "";//访问令牌AT-------CC模式，AC模式都可，推荐CC模式获取令牌
    private String TOKEN = "";

    private HttpClientUtils httpClientUtils;

    static {

        ResourceBundle rb = ConfigUtils.getResourceBundle("sms_config");
        SMS_APP_ID = rb.getString("SMS_APPID");
        SMS_APP_SECRET = rb.getString("SMS_APP_SECRET");
        SMS_SEND_API = rb.getString("SMS_SEND_API");
        SMS_ACCESS_TOKEN_API = rb.getString("SMS_ACCESS_TOKEN_API");
        SMS_TOKEN_API = rb.getString("SMS_TOKEN_API");
    }


    public SendSmsAuthCode() {

        this.httpClientUtils = new HttpClientUtils();
    }

    private String getAccessToken() {

        return (String) new CCATModel().getResObject(httpClientUtils.accessTokenPostRequest(SMS_ACCESS_TOKEN_API, new CCATModel(SMS_APP_ID, SMS_APP_SECRET)), CCATModel.ACCESS_TOKEN);
    }

    private String getToken() {
        this.ACCESS_TOKEN = getAccessToken();
        if (this.ACCESS_TOKEN == null)
            return null;
        return TokenModel.getToken(httpClientUtils.tokenGetRequest(SMS_TOKEN_API, new TokenModel(SMS_APP_ID, this.ACCESS_TOKEN)));
    }

    public boolean sendAuthCode(String phoneNumber, String code) {

        this.ACCESS_TOKEN = getAccessToken();
        this.TOKEN = getToken();
        if (this.ACCESS_TOKEN == null || this.TOKEN == null)
            return false;

        String resString = httpClientUtils.sendSmsPostRequest(SMS_SEND_API, new SMSModel(SMS_APP_ID, ACCESS_TOKEN, TOKEN, phoneNumber, code));

        if (resString == null || resString.length() == 0)
            return false;

        JSONObject jsonObject = JSON.parseObject(resString);
        if ((int) jsonObject.get("res_code") != 0)
            return false;

        return true;
    }

/*
    public static void main(String[] args) {
        SendSmsAuthCode sendSMSauthCode = new SendSmsAuthCode();

        //sendSMSauthCode.sendAuthCode("1234", "1234");
        //System.out.println(sendSMSauthCode.getToken());
        sendSMSauthCode.sendAuthCode("18285117781", "886231");
    }*/


}
