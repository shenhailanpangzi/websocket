package com.lanpang.httpserver.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @program: websocket
 * @description:
 * @author: yanghao
 * @create: 2018-10-25 16:21
 **/
public class HttpUtil {
    protected Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    private static HttpUtil instance = null;

    private HttpUtil() {
    }

    public static HttpUtil getInstance() {
        if (instance == null) {
            instance = new HttpUtil();
        }

        return instance;
    }

    public String sendHttpPost(String httpUrl) {
        HttpPost httpPost = new HttpPost(httpUrl);
        return this.sendHttpPost(httpPost);
    }

    public String sendHttpPost(String httpUrl, String params, String contentType) {
        HttpPost httpPost = new HttpPost(httpUrl);

        try {
            StringEntity stringEntity = new StringEntity(params, "UTF-8");
            stringEntity.setContentType(contentType);
            httpPost.setEntity(stringEntity);
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }

        return this.sendHttpPost(httpPost);
    }

    public String sendHttpPost(String httpUrl, String params) {
        return this.sendHttpPost(httpUrl, params, "application/x-www-form-urlencoded");
    }

    public String sendHttpPost(String httpUrl, Map<String, String> maps) {
        HttpPost httpPost = new HttpPost(httpUrl);
        List<NameValuePair> nameValuePairs = new ArrayList();
        Iterator var5 = maps.keySet().iterator();

        while(var5.hasNext()) {
            String key = (String)var5.next();
            nameValuePairs.add(new BasicNameValuePair(key, (String)maps.get(key)));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }

        return this.sendHttpPost(httpPost);
    }

    public String sendHttpPost(String httpUrl, Map<String, String> maps, List<File> fileLists) {
        HttpPost httpPost = new HttpPost(httpUrl);
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
        Iterator var6 = maps.keySet().iterator();

        while(var6.hasNext()) {
            String key = (String)var6.next();
            meBuilder.addPart(key, new StringBody((String)maps.get(key), ContentType.TEXT_PLAIN));
        }

        var6 = fileLists.iterator();

        while(var6.hasNext()) {
            File file = (File)var6.next();
            FileBody fileBody = new FileBody(file);
            meBuilder.addPart("files", fileBody);
        }

        HttpEntity reqEntity = meBuilder.build();
        httpPost.setEntity(reqEntity);
        return this.sendHttpPost(httpPost);
    }

    private String sendHttpPost(HttpPost httpPost) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;

        try {
            httpClient = HttpClients.createDefault();
            response = httpClient.execute(httpPost);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception var14) {
            throw new RuntimeException(var14);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }

                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var13) {
                var13.printStackTrace();
            }

        }

        return responseContent;
    }
}
