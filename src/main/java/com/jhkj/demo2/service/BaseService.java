package com.jhkj.demo2.service;

import com.jhkj.demo2.client.HttpClientService;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.exception.LotteryApiException;

import java.io.IOException;
import java.util.Map;

/**
 * Created by wgt on 2017/4/10.
 */
public class BaseService {

    private String requestUrl;  //请求的连接
    private HttpClientService httpClientService;

    public BaseService(String requestUrl){
        try {
            this.requestUrl = requestUrl;
            Class c=Class.forName(ApiConstant.HttpsRequestClassName);
            httpClientService=(HttpClientService)c.newInstance();
        } catch (Exception e) {
            throw new LotteryApiException(e);
        }
    }

    public String sendPost(Map<String,Object>params){
        try {
            String result = httpClientService.execute(requestUrl,params);
            return result;
        }catch (IOException e) {
            throw new LotteryApiException(e);
        }
    }

    protected void isNull(){
        if (httpClientService==null){throw new NullPointerException("HttpClientService is null");}
        if (ApiConfig.getAppId().trim().equals("")){throw new NullPointerException("appId is null!");}
        if (ApiConfig.getSignKey().trim().equals("")){throw new NullPointerException("signKey is null");}
    }
}
