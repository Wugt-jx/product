package com.jhkj.demo3.api;

import com.jhkj.demo3.exception.LotteryApiException;
import com.jhkj.demo3.response.ResultResponse;

/**
 * Created by wgt on 2017/3/28.
 */
public interface ILotteryApi {

    public ResultResponse getSignKey() throws LotteryApiException;


    public ResultResponse createLotteryEx(int quantity, int amount, String customerId, String orderNo) throws LotteryApiException;


    public ResultResponse getAwardInfoEx(String issue, int currentPage, int showCount)throws LotteryApiException;


    public ResultResponse getIssue(String issue, int currentPage, int showCount)throws LotteryApiException;


    public ResultResponse getCurrentIssue(Integer gameCode)throws LotteryApiException;


    public ResultResponse getLotteryListByCustomerId(String customerId, int currentPage, int showCount)throws LotteryApiException;


    public ResultResponse getLotteryListByOrderNo(int currentPage, int showCount, String orderNo)throws LotteryApiException;


    public ResultResponse getAccountBalance()throws LotteryApiException;


    public ResultResponse encashToAccount(int amount, String customerId)throws LotteryApiException;


    public ResultResponse getCustomerWinBalance(String customerId)throws LotteryApiException;


    public ResultResponse createAdvanceToken(String extra, String customerId, String bindIP, int amount, String retcallUrl)throws LotteryApiException;


    public ResultResponse getWithdrawalList(String customerId, int currentPage, int showCount)throws LotteryApiException;

    public ResultResponse getAccountDetail(int type)throws LotteryApiException;
}
