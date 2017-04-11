package com.jhkj.demo2.response.create_advanceToken;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class CreateAdvanceTokenResponse extends BaseResponse{
    private CreateAdvanceTokenData data;

    public CreateAdvanceTokenResponse() {
    }

    public CreateAdvanceTokenData getData() {
        return data;
    }

    public void setData(CreateAdvanceTokenData data) {
        this.data = data;
    }
}
