package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.exception.LotteryApiException;
import com.jhkj.demo2.response.create_lotteryEX.CreateLotteryExResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/10.
 */
public class CreateLotteryExService extends BaseService {
    public CreateLotteryExService() {
        super(ApiConstant.HTTP_CREATELOTTERYEX_URL);
    }

    public CreateLotteryExResponse request(int quantity, int amount, String customerId, String orderNo) {
        this.isNull();
        if (quantity>10||quantity<1){throw new LotteryApiException("quantity must between 1 and 10");}
        if (amount<10){
            throw new LotteryApiException("amount can't less 10");
        }else if (200<amount&&amount<19800){
            if (amount%2!=0){
                throw new LotteryApiException("Amount is greater than or equal to 200 and less than or equal to 19800 integer times must be 2");
            }
        }
        if (customerId==null||customerId.trim().equals("")){throw new NullPointerException("customerId is null!");}
        if (orderNo==null||orderNo.trim().equals("")){throw new NullPointerException("orderNo is null");}

        Map<String,Object>params=new HashMap<String, Object>();
        params.put("amount",amount);
        params.put("customerId",customerId);
        params.put("orderNo",orderNo);
        params.put("quantity",quantity);

        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());
        return JSONObject.parseObject(sendPost(params), CreateLotteryExResponse.class);
    }
}
