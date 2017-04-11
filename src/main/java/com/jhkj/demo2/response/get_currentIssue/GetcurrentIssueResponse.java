package com.jhkj.demo2.response.get_currentIssue;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetcurrentIssueResponse extends BaseResponse{
    private GetCurrentIssueData data;

    public GetcurrentIssueResponse() {
    }

    public GetCurrentIssueData getData() {
        return data;
    }

    public void setData(GetCurrentIssueData data) {
        this.data = data;
    }
}
