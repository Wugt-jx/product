package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.response.get_signkey.GetSignKeyResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetSignKeyService extends BaseService {


    public GetSignKeyService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(ApiConstant.HTTP_GETSIGN_URL);
    }

    public GetSignKeyResponse request() {
        if (ApiConfig.getAppId().trim().equals("")){
            throw new NullPointerException("appId is null");
        }
        if (ApiConfig.getSecureKey().trim().equals("")){
            throw new NullPointerException("secureKey is null");
        }

        Map<String,Object>params=new HashMap<String, Object>();

        params= LotteryUtil.getPostParams(params,ApiConfig.getSecureKey());
        return JSONObject.parseObject(sendPost(params), GetSignKeyResponse.class);
    }
}
