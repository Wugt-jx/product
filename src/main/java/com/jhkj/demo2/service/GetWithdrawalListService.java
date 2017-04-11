package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.exception.LotteryApiException;
import com.jhkj.demo2.response.get_withdrawalList.GetWithdrawalListResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/11.
 */
public class GetWithdrawalListService extends BaseService {
    public GetWithdrawalListService() {
        super(ApiConstant.HTTP_GETWITHDRAWALLIST_URL);
    }

    public GetWithdrawalListResponse request(String customerId, int currentPage, int showCount){
        this.isNull();
        if (customerId==null||customerId.trim().equals("")){throw new NullPointerException("customerId is null");}
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){throw new LotteryApiException("showCount can't  greater than 20");}
            showCount=10;
        }
        Map<String,Object>params=new HashMap<String, Object>();
        params.put("customerId",customerId);
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());
        return JSONObject.parseObject(sendPost(params), GetWithdrawalListResponse.class);
    }
}
