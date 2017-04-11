package com.jhkj.demo2.response.encash_toAccount;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class EncashToAccountResponse extends BaseResponse {
    private EncashToAccountData data;

    public EncashToAccountResponse() {
    }

    public EncashToAccountData getData() {
        return data;
    }

    public void setData(EncashToAccountData data) {
        this.data = data;
    }
}
