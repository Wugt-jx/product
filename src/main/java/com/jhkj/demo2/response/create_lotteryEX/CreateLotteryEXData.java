package com.jhkj.demo2.response.create_lotteryEX;

import java.util.List;

/**
 * Created by wgt on 2017/4/10.
 */
public class CreateLotteryEXData {
    private String orderNo;
    private String customerId;
    private List<LotteryInfo>lotterys;

    public CreateLotteryEXData() {
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<LotteryInfo> getLotterys() {
        return lotterys;
    }

    public void setLotterys(List<LotteryInfo> lotterys) {
        this.lotterys = lotterys;
    }
}
