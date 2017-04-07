package com.jhkj.demo3.response;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class EncashToAccountResponse implements Serializable {
    private static final long serialVersionUID = 3365218305374327748L;
    private Integer customerWinBalance;
    private Integer accountBalance;

    public EncashToAccountResponse() {
    }

    public Integer getCustomerWinBalance() {
        return customerWinBalance;
    }

    public void setCustomerWinBalance(Integer customerWinBalance) {
        this.customerWinBalance = customerWinBalance;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }
}
