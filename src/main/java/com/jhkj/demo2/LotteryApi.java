package com.jhkj.demo2;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wgt on 2017/3/28.
 */
public class LotteryApi implements ILotteryApi {

    private ApiConfig apiConfig;
    private IHttpClientService httpClientService;

    public LotteryApi(ApiConfig apiConfig){
        this.apiConfig=apiConfig;
        httpClientService=new HttpClientService();
    } ;


    public JSONObject getSignKey() throws LotteryException {
        if (httpClientService==null){
            throw new NullPointerException("HttpClientService is null");
        }
        if (apiConfig.isNull()){
            throw new NullPointerException("ApiConfig is null");
        }

        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETGISN_URL+"?");
        String params="appId="+apiConfig.getAppId()+
                "&nonceStr="+apiConfig.getNonceStr()+
                "&timestamp="+apiConfig.getTimestamp();
        String sign=LotteryUtil.getSign(params,apiConfig.getSignkey());
        sb_realUrl.append(params+"&sign="+sign);
        JSONObject result=null;
        try {
            result=this.httpClientService.execute(sb_realUrl.toString());
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }

        System.out.println(result.toString());
        return result;
    }


    public JSONObject createLotteryEx(int quantity, int amount, String customerId, String orderNo) throws LotteryException {
        if (httpClientService==null){
            throw new NullPointerException("HttpClientService is null");
        }
        if (apiConfig.isNull()){
            throw new NullPointerException("ApiConfig or field is null");
        }
        if (quantity>10||quantity<1){
            throw new LotteryException("quantity must between 1 and 10");
        }
        if (amount<10){
            throw new LotteryException("amount can't less 10");
        }else if (200<amount&&amount<19800){
            if (amount%2!=0){
                throw new LotteryException("Amount is greater than or equal to 200 and less than or equal to 19800 integer times must be 2");
            }
        }
        if (customerId==null||customerId.trim().equals("")){
            throw new NullPointerException("customerId is null!");
        }
        if (orderNo==null||customerId.trim().equals("")){
            throw new NullPointerException("orderNo is null");
        }
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_CREATELOTTERYEX_URL+"?");
        String params="amount="+amount+
                "&appId="+apiConfig.getAppId()+
                "&customerId="+customerId+
                "&nonceStr="+apiConfig.getNonceStr()+
                "&orderNo="+orderNo+
                "&quantity="+quantity+
                "&timestamp="+apiConfig.getTimestamp();
        String sign=LotteryUtil.getSign(params,apiConfig.getSignkey());

        sb_realUrl.append(params+"&sign="+sign);
        JSONObject result=null;
        try {
            result=this.httpClientService.execute(sb_realUrl.toString());
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }

        System.out.println(result.toString());
        return result;
    }

    public JSONObject getAwardInfoEx(String issue, int currentPage, int showCount) throws LotteryException{
        if (issue==null||issue.trim().equals("")){
            throw new NullPointerException("issue is null");
        }
        if (currentPage==0){
            currentPage=1;
        }
        if (showCount==0){
            if (showCount>20){
                throw new LotteryException("showCount can't  greater than 20");
            }
            showCount=10;
        }
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETAWARDINFOEX_URL+"?");
        return null;
    }


    public JSONObject getIssue(String issue, int currentPage, int showCount)throws LotteryException {
        if (issue==null||issue.trim().equals("")){
            throw new NullPointerException("issue is null");
        }
        if (currentPage==0){
            currentPage=1;
        }
        if (showCount==0){
            if (showCount>20){
                throw new LotteryException("showCount can't  greater than 20");
            }
            showCount=10;
        }
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETISSUE_URL+"?");

        return null;
    }

    public JSONObject getCurrentIssue(int gameCode) {
        return null;
    }

    public JSONObject getLotteryListByCustomerId(String customerId, int currentPage, int showCount) {
        return null;
    }

    public JSONObject getLotteryListByOrderNo(int currentPage, int showCount, String orderNo) {
        return null;
    }

    public JSONObject getAccountBalance() {
        return null;
    }

    public JSONObject encashToAccount(int amount, String customerId) {
        return null;
    }

    public JSONObject getCustomerWinBalance(String customerId) {
        return null;
    }

    public JSONObject createAdvanceToken(String extra, String customerId, String bindIP, int amount, String retcallUrl) {
        return null;
    }

    public JSONObject getWithdrawalList(String customerId, String currentPage, String showCount) {
        return null;
    }
}
