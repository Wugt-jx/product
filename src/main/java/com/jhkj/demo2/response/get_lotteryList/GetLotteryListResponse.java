package com.jhkj.demo2.response.get_lotteryList;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetLotteryListResponse extends BaseResponse{
    private GetLotteryListData data;

    public GetLotteryListResponse() {
    }

    public GetLotteryListData getData() {
        return data;
    }

    public void setData(GetLotteryListData data) {
        this.data = data;
    }
}
