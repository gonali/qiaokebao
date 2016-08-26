package com.gonali.qiaokebao.utilsModel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2016/8/26.
 */
public class CCATModel {

    private final String grant_t = "client_credentials";
    private String app_id;
    private String app_secret;
    private String state;
    private String scope;

    public static final int ACCESS_TOKEN = 0;
    public static final int EXPIRES_IN = 1;
    public static final int RES_CODE = 2;
    public static final int RES_MESSAGE = 3;

    public CCATModel() {
    }

    public CCATModel(String app_id, String app_secret) {

        this.app_id = app_id;
        this.app_secret = app_secret;
    }

    public String getGrant_t() {
        return grant_t;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_secret() {
        return app_secret;
    }

    public void setApp_secret(String app_secret) {
        this.app_secret = app_secret;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {

        return "grant_type=" + this.grant_t + "&" +
                "app_id=" + this.app_id + "&" +
                "app_secret=" + this.app_secret;
    }

    public Object getResObject(String resString, int type) {

        JSONObject jsonObject =  null;

        try {
            jsonObject = JSON.parseObject(resString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        switch (type) {

            case 0:
                return jsonObject.get("access_token");
            case 1:
                return jsonObject.get("expires_in");
            case 2:
                return jsonObject.get("res_code");
            case 3:
                return jsonObject.get("res_message");
            default:
                break;
        }

        return null;

    }

}
