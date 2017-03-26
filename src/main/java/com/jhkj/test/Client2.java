package com.jhkj.test;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo.WeatherException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by wgt on 2017/3/24.
 */
public class Client2 {

    public static void main(String args[])throws Exception{
        HttpClient httpClient=new DefaultHttpClient();

        String url="http://www.weather.com.cn/data/cityinfo/101010100.html";

        HttpGet get=new HttpGet(url);
        try {
            HttpResponse response=httpClient.execute(get);
            if (response.getStatusLine().getStatusCode()==200){
                String result=EntityUtils.toString(response.getEntity(),"utf-8");
                System.out.println(result);
                JSONObject json=JSONObject.parseObject(result);
                System.out.println(json);
            }
        } catch (IOException e) {
            throw new WeatherException("请求出错",10001);
        }
    }
}
