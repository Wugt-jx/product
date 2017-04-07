package com.jhkj.demo3.response;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetAccountBalance implements Serializable {
    private static final long serialVersionUID = 9184534302686057503L;

    private String balance;

    public GetAccountBalance() {
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
