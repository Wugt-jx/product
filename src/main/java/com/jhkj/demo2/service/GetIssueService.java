package com.jhkj.demo2.service;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo2.constant.ApiConstant;
import com.jhkj.demo2.exception.LotteryApiException;
import com.jhkj.demo2.response.get_issue.GetIssueResponse;
import com.jhkj.demo2.util.LotteryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetIssueService extends BaseService {
    public GetIssueService() {
        super(ApiConstant.HTTP_GETISSUE_URL);
    }

    public GetIssueResponse request(String issue, int currentPage, int showCount){
        this.isNull();
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){throw new LotteryApiException("showCount can't  greater than 20");}
            showCount=10;
        }
        Map<String,Object>params=new HashMap<String, Object>();
        if (issue!=null&&!issue.trim().equals("")){
            params.put("issue",issue);
        }
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params= LotteryUtil.getPostParams(params,ApiConfig.getSignKey());
        return JSONObject.parseObject(sendPost(params), GetIssueResponse.class);
    }
}
