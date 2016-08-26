package com.gonali.qiaokebao.utils.authorityCode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gonali.qiaokebao.utils.ConfigUtils;
import org.apache.commons.codec.binary.Base64;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/26.
 */
public class TokenModel {

    private static String SMS_APP_SECRET;

    private String app_id;
    private String access_token;
    private String timestamp;
    private String sign;

    static {
        SMS_APP_SECRET = ConfigUtils.getResourceBundle("sms_config").getString("SMS_APP_SECRET");
    }

    public TokenModel() {
        app_id = "";
        access_token = "";
        timestamp = "";
        sign = "";
    }

    public TokenModel(String app_id, String access_token) {

        this.app_id = app_id;
        this.access_token = access_token;

    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    @Override
    public String toString() {

        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String[] array = {
                "app_id=" + this.app_id + "&",
                "access_token=" + this.access_token + "&",
                "timestamp=" + this.timestamp
        };

        Arrays.sort(array);
        String param = "";
        for (String s : array) {
            param += s;
        }


        this.sign = new String(Base64.encodeBase64(HmacSha1.getHmacSha1(param, SMS_APP_SECRET)));
        System.out.println(param + "&sign=" + this.sign);
        return encoding(param + "&sign=" + this.sign);
    }

    private String encoding(String txt) {

        char[] chars = new char[txt.length()];

        for (int i = 0; i < txt.length(); i++) {

            if (txt.charAt(i) == ' ')
                chars[i] = '+';
            else
                chars[i] = txt.charAt(i);
        }

        return new String(chars);
    }

    public static String getToken(String requestResJsonString) {

        try {
            JSONObject jsonObject = JSON.parseObject(requestResJsonString);

            return (String) jsonObject.get("token");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
