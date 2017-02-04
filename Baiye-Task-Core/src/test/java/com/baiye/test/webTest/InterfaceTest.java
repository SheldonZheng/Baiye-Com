package com.baiye.test.webTest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Baiye on 2017/2/3.
 */
public class InterfaceTest {

    private HttpClient httpclient = HttpClients.createDefault();
    private String baseUrl = "http://127.0.0.1:8080";

    @Test
    public void healthCheck()
    {
        HttpGet httpGet = new HttpGet(baseUrl.concat("/healthCheck"));
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);
    }


}
