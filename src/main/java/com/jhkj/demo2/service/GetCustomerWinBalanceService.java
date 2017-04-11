package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.response.get_customerWinBalance.GetCustomerWinBalanceResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/11.
 */
public class GetCustomerWinBalanceService extends BaseService {
    public GetCustomerWinBalanceService() {
        super(ApiConstant.HTTP_GETCUSTOMERWINBALANCE_URL);
    }
    public GetCustomerWinBalanceResponse request(String customerId){
        this.isNull();
        if (customerId==null){throw new NullPointerException("customerId is null");}
        Map<String,Object>params=new HashMap<String, Object>();
        params.put("customerId",customerId);

        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());
        return JSONObject.parseObject(sendPost(params), GetCustomerWinBalanceResponse.class);
    }
}
