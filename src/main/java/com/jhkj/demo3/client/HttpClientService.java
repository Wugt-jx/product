package com.jhkj.demo3.client;

/**
 * Created by Administrator on 2017/3/31.
 */

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo3.constant.ApiConstant;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientService {

    private static HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

    public String execute(String url, Map<String, Object> params) throws Exception {
        CloseableHttpClient httpClient=httpClientBuilder.build();

        if (url==null||url.trim().equals("")){
            throw new NullPointerException("post url is null");
        }

        List<NameValuePair> pairs = null;
        if (params != null && !params.isEmpty()) {
            pairs = new ArrayList<NameValuePair>(params.size());
            for (String key : params.keySet()) {
                pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
        }

        HttpPost httpPost= new HttpPost(url);
        if (pairs != null && pairs.size() > 0) {
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, ApiConstant.CHARSET));
        }

        CloseableHttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();

        String result=null;
        if (statusCode != 200) {
            httpPost.abort();
            JSONObject json=new JSONObject();
            json.put("code",statusCode);
            json.put("msg","The request failed");
            result = json.toString();
        }else {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, ApiConstant.CHARSET);
            }else{
                result="";
            }
            EntityUtils.consume(entity);
            response.close();
        }

        return result;
    }
}
