package com.jhkj.demo3.response;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetCustomerWinBalanceResponse implements Serializable {

    private static final long serialVersionUID = -8536257670800051362L;
    private String customerWinBalance;

    public GetCustomerWinBalanceResponse() {
    }

    public String getCustomerWinBalance() {
        return customerWinBalance;
    }

    public void setCustomerWinBalance(String customerWinBalance) {
        this.customerWinBalance = customerWinBalance;
    }
}
