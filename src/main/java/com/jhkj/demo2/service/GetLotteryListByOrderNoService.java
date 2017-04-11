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
public class GetLotteryListByOrderNoService extends BaseService {
    public GetLotteryListByOrderNoService() {
        super(ApiConstant.HTTP_GETLOTTERYLISTBYORDERNO_URL);
    }

    public GetLotteryListResponse request(int currentPage, int showCount, String orderNo){
        this.isNull();
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){throw new LotteryApiException("showCount can't  greater than 20");}
            showCount=10;
        }
        if (orderNo==null||orderNo.trim().equals("")){throw new NullPointerException("orderNo is null");}

        Map<String,Object> params=new HashMap<String, Object>();
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);
        params.put("orderNo",orderNo);
        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());

        return JSONObject.parseObject(sendPost(params), GetLotteryListResponse.class);
    }
}
