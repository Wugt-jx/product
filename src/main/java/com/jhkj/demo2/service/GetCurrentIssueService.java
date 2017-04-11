package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.response.get_currentIssue.GetcurrentIssueResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetCurrentIssueService extends BaseService {
    public GetCurrentIssueService() {
        super(ApiConstant.HTTP_GETCURRENTISSUE_URL);
    }

    public GetcurrentIssueResponse request(Integer gameCode){
        this.isNull();
        if (gameCode==null){throw new NullPointerException("gameCode is null!");}

        Map<String,Object>params=new HashMap<String, Object>();

        params.put("gameCode",gameCode);

        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());

        return JSONObject.parseObject(sendPost(params), GetcurrentIssueResponse.class);
    }
}
