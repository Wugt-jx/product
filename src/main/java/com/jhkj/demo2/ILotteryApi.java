package com.jhkj.demo2;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wgt on 2017/3/28.
 */
public interface ILotteryApi {
    /**
     * 获取token
     * @return  jsonObject
     */
    public JSONObject getSignKey() throws LotteryException;

    /**
     *出彩票
     * @param quantity  投注数量
     * @param amount    金额总量 单位：分 大于200且小于19800时必须为2的整倍数
     * @param customerId    用户自定义id
     * @param orderNo   订单号
     * @return  jsonObject
     */
    public JSONObject createLotteryEx(int quantity,int amount,String customerId,String orderNo) throws LotteryException;

    /**
     * 获取中奖记录
     * @param issue 期号
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @return  jsonObject
     */
    public JSONObject getAwardInfoEx(String issue,int currentPage,int showCount)throws LotteryException;

    /**
     * 获取期号信息
     * @param issue     期号
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @return  jsonObject
     */
    public JSONObject getIssue(String issue,int currentPage,int showCount)throws LotteryException;

    /**
     *查看当期信息
     * @param gameCode  彩票类型，双色球为201
     * @return jsonObject
     */
    public JSONObject getCurrentIssue(int gameCode)throws LotteryException;

    /**
     * 查看自定义用户彩票记录
     * @param customerId    用户自定义id
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @return jsonObject
     */
    public JSONObject getLotteryListByCustomerId(String customerId,int currentPage,int showCount)throws LotteryException;

    /**
     * 查看自定义订单号彩票
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @param orderNo       订单号
     * @return jsonObject
     */
    public JSONObject getLotteryListByOrderNo(int currentPage,int showCount,String orderNo)throws LotteryException;

    /**
     * 查看账号余额
     * @return jsonObject
     */
    public JSONObject getAccountBalance();

    /**
     * 兑付用户奖金额余额值账号余额
     * @param amount    兑付金额
     * @param customerId    自定义用户id
     * @return jsonObject
     */
    public JSONObject encashToAccount(int amount,String customerId)throws LotteryException;

    /**
     * 查看用户奖金余额
     * @param customerId 自定义用户Id
     * @return  jsonObject
     */
    public JSONObject getCustomerWinBalance(String customerId)throws LotteryException;

    /**
     * 获取提现页所需的token
     * @param extra 自定义参数，非必填项，可传空串或是null值
     * @param customerId    自定义用户Id
     * @param bindIP    客户端ip
     * @param amount    提现金额
     * @param retcallUrl    回调地址
     * @return jsonObject
     */
    public JSONObject createAdvanceToken(String extra,String customerId,String bindIP,int amount,String retcallUrl)throws LotteryException;

    /**
     * 获取提现记录
     * @param customerId    自定义用户id
     * @param currentPage   当前页数
     * @param showCount     每页显示条数
     * @return jsonObject
     */
    public JSONObject getWithdrawalList(String customerId,String currentPage,String showCount)throws LotteryException;
}
