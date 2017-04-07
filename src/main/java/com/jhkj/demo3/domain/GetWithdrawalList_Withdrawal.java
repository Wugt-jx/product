package com.jhkj.demo3.domain;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetWithdrawalList_Withdrawal implements Serializable {

    private static final long serialVersionUID = -5759268662284999259L;
    private String createTime;
    private Integer payType;
    private String customerId;
    private Integer amount;
    private Integer status;

    public GetWithdrawalList_Withdrawal() {
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
