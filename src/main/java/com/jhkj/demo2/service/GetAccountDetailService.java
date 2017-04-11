package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.exception.LotteryApiException;
import com.jhkj.demo2.response.get_accountDetail.GetAccountDetailResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/11.
 */
public class GetAccountDetailService extends BaseService {
    public GetAccountDetailService() {
        super(ApiConstant.HTTP_GETACCOUNTDETAIL_URL);
    }

    public GetAccountDetailResponse request(int type){
        isNull();
        if (type!=0 &&type!=1){
            throw new LotteryApiException("not find type");
        }
        Map<String,Object>params=new HashMap<String, Object>();
        params.put("type",type);
        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());
        return JSONObject.parseObject(sendPost(params), GetAccountDetailResponse.class);
    }
}
