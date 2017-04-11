package com.jhkj.demo2.response.get_accountDetail;

import com.jhkj.demo2.response.BaseResponse;

import java.util.List;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetAccountDetailResponse extends BaseResponse {
    private GetAccountDetailData data;

    public GetAccountDetailResponse() {
    }

    public GetAccountDetailData getData() {
        return data;
    }

    public void setData(GetAccountDetailData data) {
        this.data = data;
    }
}
