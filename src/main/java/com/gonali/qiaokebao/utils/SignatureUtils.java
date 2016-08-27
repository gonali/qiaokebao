package com.gonali.qiaokebao.utils;


import com.gonali.qiaokebao.utils.authorityCode.HmacSha1;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by TianyuanPan on 8/27/16.
 */
public class SignatureUtils {


    public static String base64HmacSha1Sign(String data, String key){

        try {
            return new String(Base64.encodeBase64(HmacSha1.getHmacSha1(data,key)),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

}
