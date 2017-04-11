package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.exception.LotteryApiException;
import com.jhkj.demo2.response.get_lotteryList.GetLotteryListResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/11.
 */
public class GetLotteryListByCustomerIdService extends BaseService {
    public GetLotteryListByCustomerIdService() {
        super(ApiConstant.HTTP_GETLOTTERYLISTBYCUSTOMERID_URL);
    }

    public GetLotteryListResponse request(String customerId, int currentPage, int showCount){
        long startTime=System.currentTimeMillis();
        this.isNull();
        if (customerId==null){throw new NullPointerException("customerId is null");}
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){
                throw new LotteryApiException("showCount can't  greater than 20");
            }
            showCount=10;
        }

        Map<String,Object>params=new HashMap<String, Object>();

        params.put("customerId",customerId);
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);
        System.out.println(System.currentTimeMillis()-startTime);
        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());
        System.out.println(System.currentTimeMillis()-startTime);
        return JSONObject.parseObject(sendPost(params), GetLotteryListResponse.class);
    }
}
