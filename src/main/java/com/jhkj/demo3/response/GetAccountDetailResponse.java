package com.jhkj.demo3.response;

import com.jhkj.demo3.domain.GetAccountDetail_AccountDetail;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetAccountDetailResponse implements Serializable {

    private static final long serialVersionUID = 1671903839025103887L;

    List<GetAccountDetail_AccountDetail>accountDetails;

    public GetAccountDetailResponse() {
    }

    public List<GetAccountDetail_AccountDetail> getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(List<GetAccountDetail_AccountDetail> accountDetails) {
        this.accountDetails = accountDetails;
    }
}
