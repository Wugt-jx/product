package com.jhkj.demo2;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wgt on 2017/3/25.
 */
public interface IHttpClientService {
    public JSONObject execute(String urlName) throws Exception;
}
