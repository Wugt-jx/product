package com.jhkj.demo2.response.get_accountDetail;

import java.util.List;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetAccountDetailData {
    private List<AccountDetailInfo> accountDetails;

    public GetAccountDetailData() {
    }

    public List<AccountDetailInfo> getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(List<AccountDetailInfo> accountDetails) {
        this.accountDetails = accountDetails;
    }
}
