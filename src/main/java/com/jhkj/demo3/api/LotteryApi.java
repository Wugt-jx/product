package com.jhkj.demo3.api;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo3.client.*;
import com.jhkj.demo3.constant.ApiConstant;
import com.jhkj.demo3.exception.LotteryException;
import com.jhkj.demo3.util.LotteryUtil;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/3/28.
 */
public class LotteryApi implements ILotteryApi {

    private ApiConfig apiConfig;
    private IHttpClientService httpClientService;
    private Map<String,Object>params;
    private JSONObject result;

    public LotteryApi(ApiConfig apiConfig){
        this.apiConfig=apiConfig;
        httpClientService=new HttpClientService();
        params=new HashMap<String, Object>();
        params.put("appId",apiConfig.getAppId());
    }

    /**
     * 获取signkey
     * @return  jsonObject
     */
    public JSONObject getSignKey() throws LotteryException {
        this.isNull();
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETGISN_URL+"?");
        params= LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }


    /**
     *出彩票
     * @param quantity  投注数量
     * @param amount    金额总量 单位：分 大于200且小于19800时必须为2的整倍数
     * @param customerId    用户自定义id
     * @param orderNo   订单号
     * @return  jsonObject
     */
    public JSONObject createLotteryEx(int quantity, int amount, String customerId, String orderNo) throws LotteryException {
        this.isNull();
        if (quantity>10||quantity<1){throw new LotteryException("quantity must between 1 and 10");}
        if (amount<10){
            throw new LotteryException("amount can't less 10");
        }else if (200<amount&&amount<19800){
            if (amount%2!=0){
                throw new LotteryException("Amount is greater than or equal to 200 and less than or equal to 19800 integer times must be 2");
            }
        }
        if (customerId==null||customerId.trim().equals("")){throw new NullPointerException("customerId is null!");}
        if (orderNo==null||customerId.trim().equals("")){throw new NullPointerException("orderNo is null");}
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_CREATELOTTERYEX_URL+"?");
        params.put("amount",amount);
        params.put("customerId",customerId);
        params.put("orderNo",orderNo);
        params.put("quantity",quantity);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }


    /**
     * 获取中奖记录
     * @param issue 期号
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @return  jsonObject
     */
    public JSONObject getAwardInfoEx(String issue, int currentPage, int showCount) throws LotteryException{
        this.isNull();
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){
                throw new LotteryException("showCount can't  greater than 20");
            }
            showCount=10;
        }
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETAWARDINFOEX_URL+"?");

        if (issue!=null&&!issue.trim().equals("")){
            params.put("issue",issue);
        }
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }

    /**
     * 获取期号信息
     * @param issue     期号
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @return  jsonObject
     */
    public JSONObject getIssue(String issue, int currentPage, int showCount)throws LotteryException {
        this.isNull();
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){
                throw new LotteryException("showCount can't  greater than 20");
            }
            showCount=10;
        }
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETISSUE_URL+"?");
        if (issue!=null&&!issue.trim().equals("")){
            params.put("issue",issue);
        }
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }

    /**
     *查看当期信息
     * @param gameCode  彩票类型，双色球为201
     * @return jsonObject
     */
    public JSONObject getCurrentIssue(Integer gameCode)throws LotteryException {
        this.isNull();
        if (gameCode==null){throw new NullPointerException("gameCode is null!");}
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETCURRENTISSUE_URL+"?");
        params.put("gameCode",gameCode);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }


    /**
     * 查看自定义用户彩票记录
     * @param customerId    用户自定义id
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @return jsonObject
     */
    public JSONObject getLotteryListByCustomerId(String customerId, int currentPage, int showCount) throws LotteryException{
        this.isNull();
        if (customerId==null){throw new NullPointerException("customerId is null");}
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){
                throw new LotteryException("showCount can't  greater than 20");
            }
            showCount=10;
        }
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETLOTTERYLISTBYCUSTOMERID_URL+"?");
        params.put("customerId",customerId);
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }

    /**
     * 查看自定义订单号彩票
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @param orderNo       订单号
     * @return jsonObject
     */
    public JSONObject getLotteryListByOrderNo(int currentPage, int showCount, String orderNo) throws LotteryException{
        this.isNull();
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){throw new LotteryException("showCount can't  greater than 20");}
            showCount=10;
        }
        if (orderNo==null||orderNo.trim().equals("")){throw new NullPointerException("orderNo is null");}
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETLOTTERYLISTBYORDERNO_URL+"?");

        params.put("currentPage",currentPage);
        params.put("showCount",showCount);
        params.put("orderNo",orderNo);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }


    /**
     * 查看账号余额
     * @return jsonObject
     */
    public JSONObject getAccountBalance()throws LotteryException{
        this.isNull();
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETACCOUNTBALANCE_URL+"?");

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }

    /**
     * 查看用户奖金余额
     * @param customerId 自定义用户Id
     * @return  jsonObject
     */
    public JSONObject getCustomerWinBalance(String customerId)throws LotteryException {
        this.isNull();
        if (customerId==null){throw new NullPointerException("customerId is null");}
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETCUSTOMERWINBALANCE_URL+"?");
        params.put("customerId",customerId);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }


    /**
     * 兑付用户奖金额余额值账号余额
     * 用户中奖余额必须大于等于要兑付的金额
     * @param amount    兑付金额
     * @param customerId    自定义用户id
     * @return jsonObject
     */
    public JSONObject encashToAccount(int amount, String customerId)throws LotteryException {
        this.isNull();
        if (amount<1){throw new LotteryException("amount too less than ");}
        if (customerId==null){throw new NullPointerException("customerId is null");}
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_ENCASHTOACCOUNT_URL+"?");
        params.put("amount",amount);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }


    /**
     * 获取提现页所需的token
     * @param extra 自定义参数，非必填项，可传空串或是null值
     * @param customerId    自定义用户Id
     * @param bindIP    客户端ip
     * @param amount    提现金额
     * @param retcallUrl    回调地址
     * @return jsonObject
     */
    public JSONObject createAdvanceToken(String extra, String customerId, String bindIP, int amount, String retcallUrl)throws LotteryException {
        this.isNull();
        if (customerId==null){throw new NullPointerException("customerId is null");}
        if(bindIP==null){throw new NullPointerException("bindIP is null");}
        if (amount<100){throw new LotteryException("amount must be greater than 100");}
        if (retcallUrl==null){throw new NullPointerException("retcallUrl is null");}

        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_CREATEADVANCETOKEN_URL+"?");
        if (extra!=null&&!extra.trim().equals("")){
            params.put("extra",extra);
        }
        params.put("amount",amount);
        params.put("customerId",customerId);
        params.put("bindIP",bindIP);
        params.put("retcallUrl",retcallUrl);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }


    /**
     * 获取提现记录
     * @param customerId    自定义用户id
     * @param currentPage   当前页数
     * @param showCount     每页显示条数
     * @return jsonObject
     */
    public JSONObject getWithdrawalList(String customerId, int currentPage, int showCount)throws LotteryException {
        this.isNull();
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){throw new LotteryException("showCount can't  greater than 20");}
            showCount=10;
        }
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETWITHDRAWALLIST_URL+"?");
        params.put("customerId",customerId);
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }

    /**
     *
     * @param type
     * @return
     * @throws LotteryException
     */
    public JSONObject getAccountDetail(int type)throws LotteryException{
        isNull();
        if (type!=0 &&type!=1){
            throw new LotteryException("not find type");
        }
        StringBuilder sb_realUrl=new StringBuilder(ApiConstant.HTTP_URL+ApiConstant.HTTP_GETACCOUNTDETAIL_URL+"?");
        params.put("type",type);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(sb_realUrl.toString(),params);
        }catch (Exception e){
            throw new LotteryException(e.getMessage());
        }
        return result;
    }

    /**
     * 判断当前的apiConfig和httpClientService是否为空
     */
    private void isNull(){
        if (httpClientService==null){throw new NullPointerException("HttpClientService is null");}
        if (apiConfig==null){throw new NullPointerException("ApiConfig is null");}
    }
}
