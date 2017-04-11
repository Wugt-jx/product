package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.response.get_accountBalance.GetAccountBalanceResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/11.
 */
public class GetAccountBalanceService extends BaseService {
    public GetAccountBalanceService() {
        super(ApiConstant.HTTP_GETACCOUNTBALANCE_URL);
    }

    public GetAccountBalanceResponse request(){
        this.isNull();
        Map<String,Object>params=new HashMap<String, Object>();
        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());
        return JSONObject.parseObject(sendPost(params), GetAccountBalanceResponse.class);
    }
}
