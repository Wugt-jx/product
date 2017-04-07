package com.jhkj.demo3.response;

import com.jhkj.demo3.domain.CreateLotteryEx_Lotterys;

import java.util.List;

/**
 * Created by wgt on 2017/4/7.
 */
public class CreateLotteryExResponse {


    private String orderNo;
    private String customerId;
    private List<CreateLotteryEx_Lotterys> lotterys;

    public CreateLotteryExResponse() {
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

    public List<CreateLotteryEx_Lotterys> getLotterys() {
        return lotterys;
    }

    public void setLotterys(List<CreateLotteryEx_Lotterys> lotterys) {
        this.lotterys = lotterys;
    }
}
