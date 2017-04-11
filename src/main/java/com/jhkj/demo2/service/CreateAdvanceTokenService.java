package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.exception.LotteryApiException;
import com.jhkj.demo2.response.create_advanceToken.CreateAdvanceTokenResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/11.
 */
public class CreateAdvanceTokenService extends BaseService {
    public CreateAdvanceTokenService() {
        super(ApiConstant.HTTP_CREATEADVANCETOKEN_URL);
    }

    public CreateAdvanceTokenResponse request(String extra, String customerId, String bindIP, int amount, String retcallUrl){
        this.isNull();
        if (customerId==null){throw new NullPointerException("customerId is null");}
        if(bindIP==null){throw new NullPointerException("bindIP is null");}
        if (amount<100){throw new LotteryApiException("amount must be greater than 100");}
        if (retcallUrl==null){throw new NullPointerException("retcallUrl is null");}

        Map<String,Object>params=new HashMap<String, Object>();
        if (extra!=null&&!extra.trim().equals("")){
            params.put("extra",extra);
        }
        params.put("amount",amount);
        params.put("customerId",customerId);
        params.put("bindIP",bindIP);
        params.put("retcallUrl",retcallUrl);

        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());
        return JSONObject.parseObject(sendPost(params), CreateAdvanceTokenResponse.class);
    }
}
