package com.jhkj.demo2.response.get_withdrawalList;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetWithdrawalListResponse extends BaseResponse{
    private GetWithdrawalListData data;

    public GetWithdrawalListResponse() {
    }

    public GetWithdrawalListData getData() {
        return data;
    }

    public void setData(GetWithdrawalListData data) {
        this.data = data;
    }
}
