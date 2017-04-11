package com.jhkj.demo2.response.get_withdrawalList;

import java.util.List;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetWithdrawalListData {
    private List<WithdrawalListInfo> withdrawals;

    public GetWithdrawalListData() {
    }

    public List<WithdrawalListInfo> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<WithdrawalListInfo> withdrawals) {
        this.withdrawals = withdrawals;
    }
}
