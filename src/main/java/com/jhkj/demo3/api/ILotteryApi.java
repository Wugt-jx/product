package com.jhkj.demo3.api;

import com.jhkj.demo3.exception.LotteryApiException;
import com.jhkj.demo3.response.ResultResponse;

/**
 * Created by wgt on 2017/3/28.
 */
public interface ILotteryApi {

    public ResultResponse getSignKey();


    public ResultResponse createLotteryEx(int quantity, int amount, String customerId, String orderNo) ;


    public ResultResponse getAwardInfoEx(String issue, int currentPage, int showCount);


    public ResultResponse getIssue(String issue, int currentPage, int showCount);


    public ResultResponse getCurrentIssue(Integer gameCode);


    public ResultResponse getLotteryListByCustomerId(String customerId, int currentPage, int showCount);


    public ResultResponse getLotteryListByOrderNo(int currentPage, int showCount, String orderNo);


    public ResultResponse getAccountBalance();


    public ResultResponse encashToAccount(int amount, String customerId);


    public ResultResponse getCustomerWinBalance(String customerId);


    public ResultResponse createAdvanceToken(String extra, String customerId, String bindIP, int amount, String retcallUrl);


    public ResultResponse getWithdrawalList(String customerId, int currentPage, int showCount);

    public ResultResponse getAccountDetail(int type);
}
