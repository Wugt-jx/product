package com.jhkj.demo2.response.get_accountBalance;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetAccountBalanceResponse extends BaseResponse {
    private GetAccountBalanceData data;

    public GetAccountBalanceResponse() {
    }

    public GetAccountBalanceData getData() {
        return data;
    }

    public void setData(GetAccountBalanceData data) {
        this.data = data;
    }
}
