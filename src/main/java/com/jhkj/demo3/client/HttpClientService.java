package com.jhkj.demo3.client;

/**
 * Created by Administrator on 2017/3/31.
 */

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo3.exception.LotteryException;
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
public class HttpClientService implements IHttpClientService {
    private HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    private  CloseableHttpClient httpClient;
    private  HttpPost httpPost;
    private  String result;
    private final String CHARSET = "UTF-8";



    @Override
    public JSONObject execute(String url, Map<String, Object> params) throws Exception {
        httpClient=httpClientBuilder.build();
        if (url==null||url.trim().equals("")){
            throw new NullPointerException("post url is not null");
        }

        try {
            List<NameValuePair> pairs = null;
            if (params != null && !params.isEmpty()) {
                pairs = new ArrayList<NameValuePair>(params.size());
                for (String key : params.keySet()) {
                    pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
                }
            }
            httpPost= new HttpPost(url);
            if (pairs != null && pairs.size() > 0) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            if (statusCode != 200) {
                httpPost.abort();
                JSONObject json=new JSONObject();
                json.put("code",statusCode);
                json.put("msg","The request failed");
                result = json.toString();
            }else {
                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    result = "";
                }
                result = EntityUtils.toString(entity, CHARSET);
                EntityUtils.consume(entity);
                response.close();
            }
            return JSONObject.parseObject(result);
        } catch (Exception e) {
            throw new LotteryException(e.getMessage());
        }
    }
}
