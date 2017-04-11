package com.jhkj.demo2.response.get_lotteryList;

import com.jhkj.demo2.response.BaseResponse;

import java.util.List;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetLotteryListData {
    private List<LotteryListInfo> lotterys;

    public GetLotteryListData() {
    }

    public List<LotteryListInfo> getLotterys() {
        return lotterys;
    }

    public void setLotterys(List<LotteryListInfo> lotterys) {
        this.lotterys = lotterys;
    }
}
