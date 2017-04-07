package com.jhkj.demo3.domain;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetAccountDetail_AccountDetail implements Serializable{

    private static final long serialVersionUID = -1473258704951618265L;
    private String orderNo;
    private String customerId;
    private String createTime;
    private String remark;
    private Integer amount;

    public GetAccountDetail_AccountDetail() {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
