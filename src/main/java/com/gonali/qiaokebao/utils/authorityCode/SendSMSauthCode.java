package com.gonali.qiaokebao.utils.authorityCode;

import com.gonali.qiaokebao.utils.ConfigUtils;
import com.gonali.qiaokebao.utils.HttpClientUtils;
import com.gonali.qiaokebao.utilsModel.CCATModel;

import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/8/26.
 */
public class SendSMSauthCode {

    private static String SMS_APP_ID = "279571240000256451";//应用ID------登录平台在应用设置可以找到
    private static String SMS_APP_SECRET = "e9c8c5bcfbfb3ca77bdde023940dc763";//应用secret-----登录平台在应用设置可以找到
    private static String SMS_API = "";
    private static String SMS_ACCESS_TOKEN_API = "";

    private String ACCESS_TOKEN = "";//访问令牌AT-------CC模式，AC模式都可，推荐CC模式获取令牌

    private HttpClientUtils httpClientUtils;

    static {

        ResourceBundle rb = ConfigUtils.getResourceBundle("sms_config");
        SMS_APP_ID = rb.getString("SMS_APPID");
        SMS_APP_SECRET = rb.getString("SMS_APP_SECRET");
        SMS_API = rb.getString("SMS_API");
        SMS_ACCESS_TOKEN_API = rb.getString("SMS_ACCESS_TOKEN_API");
    }


    public SendSMSauthCode(){

        this.httpClientUtils = new HttpClientUtils();
    }

    private String getAccessToken(){

        try {
            return (String) new CCATModel().getResObject(httpClientUtils.accessTokenPostRequest(SMS_ACCESS_TOKEN_API, new CCATModel(SMS_APP_ID, SMS_APP_SECRET)), CCATModel.ACCESS_TOKEN);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean sendAuthCode(String phoneNumber, String code){

        this.ACCESS_TOKEN = getAccessToken();
        if(this.ACCESS_TOKEN==null)
            return false;

        return true;
    }


    public static void main(String[] args) {
        SendSMSauthCode sendSMSauthCode = new SendSMSauthCode();

        sendSMSauthCode.sendAuthCode("1234", "1234");
    }


}
