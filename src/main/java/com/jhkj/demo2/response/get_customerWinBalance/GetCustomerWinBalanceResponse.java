package com.jhkj.demo2.response.get_customerWinBalance;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetCustomerWinBalanceResponse extends BaseResponse {
    private GetCustomerWinBalanceData data;

    public GetCustomerWinBalanceResponse() {
    }

    public GetCustomerWinBalanceData getData() {
        return data;
    }

    public void setData(GetCustomerWinBalanceData data) {
        this.data = data;
    }
}
