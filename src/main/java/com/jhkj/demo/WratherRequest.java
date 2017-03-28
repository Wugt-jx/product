package com.jhkj.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by wgt on 2017/3/24.
 */

public class WratherRequest {

    public WeatherResponse<WeatherInfo> queryWeather(){
        HttpClient httpClient=new DefaultHttpClient();

        String url="http://www.weather.com.cn/data/cityinfo/101010100.html";

        HttpGet get=new HttpGet(url);

        WeatherResponse<WeatherInfo>infoWeatherResponse =new WeatherResponse<WeatherInfo>();
        try {
            HttpResponse response=httpClient.execute(get);
            if (response.getStatusLine().getStatusCode()==200){
                String result= EntityUtils.toString(response.getEntity(),"utf-8");
                System.out.println("String"+result);
                JSONObject json=JSON.parseObject(result);
                System.out.println("JSON"+json);
                WeatherInfo info=json.getObject("weatherinfo",WeatherInfo.class);
                System.out.println(info);
            }
        } catch (IOException e) {
            throw new WeatherException("请求出错",10001);
        }

        return infoWeatherResponse;
    }


    public static void main(String args[]){
        WratherRequest request=new WratherRequest();
        WeatherResponse response=request.queryWeather();
        System.out.println(JSONObject.toJSONString(response));
    }
}
