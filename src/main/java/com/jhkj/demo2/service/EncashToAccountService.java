package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.exception.LotteryApiException;
import com.jhkj.demo2.response.encash_toAccount.EncashToAccountResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/11.
 */
public class EncashToAccountService extends BaseService{
    public EncashToAccountService() {
        super(ApiConstant.HTTP_ENCASHTOACCOUNT_URL);
    }

    public EncashToAccountResponse request(int amount, String customerId){
        this.isNull();
        if (amount<1){throw new LotteryApiException("amount too less than ");}
        if (customerId==null){throw new NullPointerException("customerId is null");}

        Map<String,Object>params=new HashMap<String, Object>();
        params.put("amount",amount);
        params.put("customerId",customerId);

        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());
        return JSONObject.parseObject(sendPost(params), EncashToAccountResponse.class);
    }
}
