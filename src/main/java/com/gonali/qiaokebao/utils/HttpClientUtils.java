package com.gonali.qiaokebao.utils;


import com.gonali.qiaokebao.utils.authorityCode.CCATModel;
import com.gonali.qiaokebao.utils.authorityCode.SMSModel;
import com.gonali.qiaokebao.utils.authorityCode.TokenModel;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class HttpClientUtils {

    //是否启用代理
    public static boolean isProxy = false;
    private static String proxyHost = "";
    private static int proxyPort;
    public static int connectionTimeOut = 6000;
    public static int requestTimeOut = 6000;
    public static int readTimeOut = 30000;

    public String responseBody2(String url, String data) {
        StringBuffer buf = new StringBuffer();

        return buf.toString();
    }


    /**
     * @param url
     * @param model
     * @return
     * @throws Exception
     */
    public String accessTokenPostRequest(String url, CCATModel model) {

        StringBuffer buf = new StringBuffer();
        InputStream resStream = null;

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(readTimeOut)
                .setConnectTimeout(connectionTimeOut)
                .setConnectionRequestTimeout(requestTimeOut)
                .build();


        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig).build();

        HttpPost postRequest = new HttpPost(url);
        // 创建参数队列
        List<BasicNameValuePair> formparams = new ArrayList<>();
        formparams.add(new BasicNameValuePair("grant_type", model.getGrant_t()));
        formparams.add(new BasicNameValuePair("app_id", model.getApp_id()));
        formparams.add(new BasicNameValuePair("app_secret", model.getApp_secret()));
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            postRequest.setEntity(uefEntity);
            System.out.println("executing request " + postRequest.getURI());
            CloseableHttpResponse response = httpClient.execute(postRequest);
            try {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    System.out.println("Response Conde: " + response.getStatusLine().getStatusCode());
                    return EntityUtils.toString(responseEntity, "UTF-8");
                } else
                    return null;

            } catch (Exception ex) {
                ex.printStackTrace();
                return null;

            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public String tokenPostRequest(String url, TokenModel model){

        return null;
    }


    public String sendSmsPostRequest(String url, SMSModel model) {

       /* StringBuffer buf = new StringBuffer();
        InputStream resStream = null;

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(readTimeOut)
                .setConnectTimeout(connectionTimeOut)
                .setConnectionRequestTimeout(requestTimeOut)
                .build();


        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig).build();

        HttpPost postRequest = new HttpPost(url);
        // 创建参数队列
        List<BasicNameValuePair> formparams = new ArrayList<>();
        formparams.add(new BasicNameValuePair("grant_type", model.getGrant_t()));
        formparams.add(new BasicNameValuePair("app_id", model.getApp_id()));
        formparams.add(new BasicNameValuePair("app_secret", model.getApp_secret()));
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            postRequest.setEntity(uefEntity);
            System.out.println("executing request " + postRequest.getURI());
            CloseableHttpResponse response = httpClient.execute(postRequest);
            try {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    System.out.println("Response Conde: " + response.getStatusLine().getStatusCode());
                    return EntityUtils.toString(responseEntity, "UTF-8");
                } else
                    return null;

            } catch (Exception ex) {
                ex.printStackTrace();
                return null;

            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

       return null;

    }

}


