package com.jhkj.demo2.response.get_awardInfo;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetAwardInfoResponse extends BaseResponse {
    private GetAwardInfoData data;

    public GetAwardInfoResponse() {
    }

    public GetAwardInfoData getData() {
        return data;
    }

    public void setData(GetAwardInfoData data) {
        this.data = data;
    }
}
