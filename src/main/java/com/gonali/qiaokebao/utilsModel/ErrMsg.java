package com.gonali.qiaokebao.utilsModel;

/**
 * Created by Administrator on 2016/8/27.
 */
public final class ErrMsg {

    private static final String[] message = {
       //msg 0
         "success.",
       //msg 1
        "request data null.",
       //msg 2
         "Server internal error, JSON data parser Failed.",
       //msg 3
         "Send SMS auth code error!!!",
       //msg 4
          "Server internal error, write to RgstrLog error."
       //msg 5
       //msg 6
       //msg 7
       //msg 8
       //msg 9
       //msg 10
       //msg 11
       //msg 12
       //msg 13
       //msg 14
       //msg 15
       //msg 16
       //msg 17
       //msg 18
    };


    public static String getErrMsg(int code){

        try {
            return message[code];
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
