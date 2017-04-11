package com.jhkj.demo2.response.get_issue;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetIssueResponse extends BaseResponse{
    private GetIssueData data;

    public GetIssueResponse() {
    }

    public GetIssueData getData() {
        return data;
    }

    public void setData(GetIssueData data) {
        this.data = data;
    }
}
