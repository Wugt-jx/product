package com.jhkj.demo3.api;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo3.exception.LotteryException;

/**
 * Created by wgt on 2017/3/28.
 */
public interface ILotteryApi {

    public JSONObject getSignKey() throws LotteryException;


    public JSONObject createLotteryEx(int quantity, int amount, String customerId, String orderNo) throws LotteryException;


    public JSONObject getAwardInfoEx(String issue, int currentPage, int showCount)throws LotteryException;


    public JSONObject getIssue(String issue, int currentPage, int showCount)throws LotteryException;


    public JSONObject getCurrentIssue(Integer gameCode)throws LotteryException;


    public JSONObject getLotteryListByCustomerId(String customerId, int currentPage, int showCount)throws LotteryException;


    public JSONObject getLotteryListByOrderNo(int currentPage, int showCount, String orderNo)throws LotteryException;


    public JSONObject getAccountBalance()throws LotteryException;


    public JSONObject encashToAccount(int amount, String customerId)throws LotteryException;


    public JSONObject getCustomerWinBalance(String customerId)throws LotteryException;


    public JSONObject createAdvanceToken(String extra, String customerId, String bindIP, int amount, String retcallUrl)throws LotteryException;


    public JSONObject getWithdrawalList(String customerId, int currentPage, int showCount)throws LotteryException;

    public JSONObject getAccountDetail(int type)throws LotteryException;
}
