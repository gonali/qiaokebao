package com.gonali.qiaokebao.utils.authorityCode;

import com.gonali.qiaokebao.utils.ConfigUtils;
import org.apache.commons.codec.binary.Base64;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/26.
 */
public class SMSModel {

    private static String SMS_APP_SECRET;

    private String app_id;
    private String access_token;
    private String token;
    private String phone;
    private String randcode;
    private int exp_time;
    private String timestamp;
    private String sign;

    static {
        SMS_APP_SECRET = ConfigUtils.getResourceBundle("sms_config").getString("SMS_APP_SECRET");
    }

    public SMSModel() {

        app_id = "";
        access_token = "";
        token = "";
        phone = "";
        randcode = "";
        exp_time = 10;
        timestamp = "";
        sign = "";
    }

    public SMSModel(String app_id, String access_token, String token, String phone, String randcode) {

        this.app_id = app_id;
        this.access_token = access_token;
        this.token = token;
        this.phone = phone;
        this.randcode = randcode;
        exp_time = 10;
        timestamp = "";

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRandcode() {
        return randcode;
    }

    public void setRandcode(String randcode) {
        this.randcode = randcode;
    }

    public int getExp_time() {
        return exp_time;
    }

    public void setExp_time(int exp_time) {
        this.exp_time = exp_time;
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
                "phone=" + this.phone + "&",
                "randcode=" + this.randcode + "&",
                "exp_time=" + this.exp_time + "&",
                "timestamp=" + this.timestamp + "&",
                "token=" + this.token
        };

        Arrays.sort(array);
        String param = "";
        for (String s : array) {
            param += s;
        }
        this.sign = new String(Base64.encodeBase64(HmacSha1.getHmacSha1(param, SMS_APP_SECRET)));
        System.out.println("Sign: " + sign);
        System.out.println("Param: " + param);
        return encoding(param + "&sign=" +this.sign);
    }

    private String encoding(String txt){

        char[] chars = new char[txt.length()];

        for(int i = 0; i < txt.length(); i++){

            if(txt.charAt(i)==' ')
                chars[i] = '+';
            else
                chars[i] = txt.charAt(i);
        }

        return new String(chars);
    }

   /* public static void main(String[] args) {
        System.out.println(new SMSModel().toString());
    }*/

}
