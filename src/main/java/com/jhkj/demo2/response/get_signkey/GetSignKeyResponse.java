package com.jhkj.demo2.response.get_signkey;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetSignKeyResponse extends BaseResponse{
    private SignKeyData data;

    public GetSignKeyResponse() {
    }

    public SignKeyData getData() {
        return data;
    }

    public void setData(SignKeyData data) {
        this.data = data;
    }
}
