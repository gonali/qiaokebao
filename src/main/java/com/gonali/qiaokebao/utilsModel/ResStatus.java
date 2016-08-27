package com.gonali.qiaokebao.utilsModel;

/**
 * Created by Administrator on 2016/8/27.
 */
public class ResStatus {

    public static String successReturn() {

        return "{\"statusCode\":" + ResCodes.SUCCESS + "}";
    }

    public static String failedReturn(int code, String message) {

        return "{\"statusCode\":" + code + "," +
                "\"message\":\"" + message + "\"}";
    }
}
