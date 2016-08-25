package com.gonali.qiaokebao.utils;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class HttpClientCommon {

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
     * httpClient 响应数据
     * @param url
     * @param data
     * @return
     * @throws Exception
     */
    public String postRequest(String url, String data) throws Exception {

        StringBuffer buf = new StringBuffer();
        InputStream resStream = null;

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(readTimeOut)
                .setConnectTimeout(connectionTimeOut)
                .setConnectionRequestTimeout(requestTimeOut)
                .build();


        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig).build();

        HttpPost request = new HttpPost(url);
        HttpEntity requestEntity = new StringEntity(data, "UTF-8");
        request.setEntity(requestEntity);


        try {

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity responseEntity = response.getEntity();

            if (statusCode == HttpStatus.SC_OK) {

                resStream = responseEntity.getContent();

                BufferedReader br = new BufferedReader(new InputStreamReader(resStream, "UTF-8"));

                StringBuffer resBuffer = new StringBuffer();

                String resTemp = "";

                while ((resTemp = br.readLine()) != null) {

                    resBuffer.append(resTemp);

                }

                String responseString = resBuffer.toString();

                buf.append(responseString);

            } else {
                throw new Exception("" + statusCode);
            }


            return buf.toString();
        } finally {
            try {
                resStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}


