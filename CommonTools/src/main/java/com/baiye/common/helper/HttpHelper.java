package com.baiye.common.helper;

import com.google.common.collect.Maps;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Baiye on 2017/2/3.
 */
public class HttpHelper {

    private static final Logger logger = LoggerFactory.getLogger(HttpHelper.class);

    /**
     * 发送 GET 请求（HTTP），K-V形式
     *
     * @param url
     * @param params
     * @return
     */
    public static String doGet(String url, Map<String, String> params) {
        String apiUrl = url;
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()) {
            if (i == 0)
                param.append("?");
            else
                param.append("&");
            param.append(key).append("=").append(params.get(key));
            i++;
        }
        apiUrl += param;
        String result = null;
        HttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(apiUrl);
            logger.info("远程调用开始,url:{}", apiUrl);
            long start = System.currentTimeMillis();
            HttpResponse response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            logger.info("执行状态码 :{} ", statusCode);
            HttpEntity entity = response.getEntity();
            if (entity != null && statusCode == 200) {
                InputStream instream = entity.getContent();
                result = IOUtils.toString(instream, "UTF-8");
            }
            long end = System.currentTimeMillis();
            logger.info("远程调用结束,result:{},耗时:{}ms", result, (end - start));
        } catch (IOException e) {
            logger.error("远程调用失败,URL:{},result:{}",apiUrl,result);
        }
        return result;
    }

    public static String doGet(String url) {
        return doGet(url, new HashMap<String, String>());
    }



    }
