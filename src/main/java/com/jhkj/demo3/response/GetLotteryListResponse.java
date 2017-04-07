package com.jhkj.demo3.response;

import com.jhkj.demo3.domain.GetLotteryList_Lottery;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetLotteryListResponse implements Serializable{
    private static final long serialVersionUID = -5488995253608006852L;

    List<GetLotteryList_Lottery> lotterys;

    public GetLotteryListResponse() {
    }

    public List<GetLotteryList_Lottery> getLotterys() {
        return lotterys;
    }

    public void setLotterys(List<GetLotteryList_Lottery> lotterys) {
        this.lotterys = lotterys;
    }
}
