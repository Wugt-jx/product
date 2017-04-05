package com.jhkj.demo3.client;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by wgt on 2017/3/25.
 */
public interface IHttpClientService {
    public JSONObject execute(String url, Map<String, Object> params) throws Exception;
}
