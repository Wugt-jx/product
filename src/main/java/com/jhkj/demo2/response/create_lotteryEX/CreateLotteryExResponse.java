package com.jhkj.demo2.response.create_lotteryEX;

import com.jhkj.demo2.response.BaseResponse;

/**
 * Created by wgt on 2017/4/10.
 */
public class CreateLotteryExResponse extends BaseResponse{
    private CreateLotteryEXData data;

    public CreateLotteryExResponse() {
    }

    public CreateLotteryEXData getData() {
        return data;
    }

    public void setData(CreateLotteryEXData data) {
        this.data = data;
    }
}
