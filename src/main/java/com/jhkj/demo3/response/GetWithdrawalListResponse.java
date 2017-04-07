package com.jhkj.demo3.response;

import com.jhkj.demo3.domain.GetWithdrawalList_Withdrawal;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetWithdrawalListResponse implements Serializable {
    private static final long serialVersionUID = 203586139320442130L;

    private List<GetWithdrawalList_Withdrawal> withdrawals;

    public GetWithdrawalListResponse() {
    }

    public List<GetWithdrawalList_Withdrawal> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<GetWithdrawalList_Withdrawal> withdrawals) {
        this.withdrawals = withdrawals;
    }
}
