package com.jhkj.demo3.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jhkj.demo3.client.*;
import com.jhkj.demo3.constant.ApiConstant;
import com.jhkj.demo3.exception.LotteryApiException;
import com.jhkj.demo3.response.*;
import com.jhkj.demo3.util.LotteryUtil;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgt on 2017/3/28.
 */
public class LotteryApi implements ILotteryApi {

    private ApiConfig apiConfig;
    private HttpClientService httpClientService;
    private Map<String,Object>params;
    private String result;

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
    public ResultResponse<GetSignKeyResponse> getSignKey() {
        if (httpClientService==null){throw new NullPointerException("HttpClientService is null");}
        if (apiConfig==null){throw new NullPointerException("ApiConfig is null");}
        if (apiConfig.getAppId()==null){throw new NullPointerException("appId is null!");}
        if (apiConfig.getSecurekey()==null){throw new NullPointerException("secureKey is null");}

        params= LotteryUtil.getPostParams(params,apiConfig.getSecurekey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETSIGN_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetSignKeyResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }


    /**
     *出彩票
     * @param quantity  投注数量
     * @param amount    金额总量 单位：分 大于200且小于19800时必须为2的整倍数
     * @param customerId    用户自定义id
     * @param orderNo   订单号
     * @return  jsonObject
     */
    public ResultResponse<CreateLotteryExResponse> createLotteryEx(int quantity, int amount, String customerId, String orderNo) {
        this.isNull();


        params.put("amount",amount);
        params.put("customerId",customerId);
        params.put("orderNo",orderNo);
        params.put("quantity",quantity);
        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_CREATELOTTERYEX_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<CreateLotteryExResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }


    /**
     * 获取中奖记录
     * @param issue 期号
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @return  jsonObject
     */
    public ResultResponse<GetAwardInfoExResponse> getAwardInfoEx(String issue, int currentPage, int showCount) {
        this.isNull();
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){throw new LotteryApiException("showCount can't  greater than 20");}
            showCount=10;
        }

        if (issue!=null&&!issue.trim().equals("")){
            params.put("issue",issue);
        }
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETAWARDINFOEX_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetAwardInfoExResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }

    /**
     * 获取期号信息
     * @param issue     期号
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @return  jsonObject
     */
    public ResultResponse<GetIssueResponse> getIssue(String issue, int currentPage, int showCount) {
        this.isNull();
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){throw new LotteryApiException("showCount can't  greater than 20");}
            showCount=10;
        }
        if (issue!=null&&!issue.trim().equals("")){
            params.put("issue",issue);
        }
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETISSUE_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetIssueResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }

    /**
     *查看当期信息
     * @param gameCode  彩票类型，双色球为201
     * @return jsonObject
     */
    public ResultResponse<GetCurrentIssueResponse> getCurrentIssue(Integer gameCode) {
        this.isNull();
        if (gameCode==null){throw new NullPointerException("gameCode is null!");}

        params.put("gameCode",gameCode);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETCURRENTISSUE_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetCurrentIssueResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }


    /**
     * 查看自定义用户彩票记录
     * @param customerId    用户自定义id
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @return jsonObject
     */
    public ResultResponse<GetLotteryListResponse> getLotteryListByCustomerId(String customerId, int currentPage, int showCount)  {
        this.isNull();
        if (customerId==null||customerId.trim().equals("")){throw new NullPointerException("customerId is null");}
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){
                throw new LotteryApiException("showCount can't  greater than 20");
            }
            showCount=10;
        }

        params.put("customerId",customerId);
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETLOTTERYLISTBYCUSTOMERID_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetLotteryListResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }

    /**
     * 查看自定义订单号彩票
     * @param currentPage   当前页数，默认为1
     * @param showCount     每页获取记录数，默认为10
     * @param orderNo       订单号
     * @return jsonObject
     */
    public ResultResponse<GetLotteryListResponse> getLotteryListByOrderNo(int currentPage, int showCount, String orderNo) throws LotteryApiException {
        this.isNull();
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){throw new LotteryApiException("showCount can't  greater than 20");}
            showCount=10;
        }
        if (orderNo==null||orderNo.trim().equals("")){throw new NullPointerException("orderNo is null");}

        params.put("currentPage",currentPage);
        params.put("showCount",showCount);
        params.put("orderNo",orderNo);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETLOTTERYLISTBYORDERNO_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetLotteryListResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e.getMessage());
        }
    }


    /**
     * 查看账号余额
     * @return jsonObject
     */
    public ResultResponse<GetAccountBalance> getAccountBalance() {
        this.isNull();
        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETACCOUNTBALANCE_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetAccountBalance>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }

    /**
     * 查看用户奖金余额
     * @param customerId 自定义用户Id
     * @return  jsonObject
     */
    public ResultResponse<GetCustomerWinBalanceResponse> getCustomerWinBalance(String customerId) {
        this.isNull();
        if (customerId==null||customerId.trim().equals("")){throw new NullPointerException("customerId is null");}

        params.put("customerId",customerId);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETCUSTOMERWINBALANCE_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetCustomerWinBalanceResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }


    /**
     * 兑付用户奖金额余额值账号余额
     * 用户中奖余额必须大于等于要兑付的金额
     * @param amount    兑付金额
     * @param customerId    自定义用户id
     * @return jsonObject
     */
    public ResultResponse<EncashToAccountResponse> encashToAccount(int amount, String customerId) {
        this.isNull();
        if (amount<1){throw new LotteryApiException("amount too less than ");}
        if (customerId==null||customerId.trim().equals("")){throw new NullPointerException("customerId is null");}

        params.put("amount",amount);
        params.put("customerId",customerId);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_ENCASHTOACCOUNT_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<EncashToAccountResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
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
    public ResultResponse<CreateAdvanceTokenResponse> createAdvanceToken(String extra, String customerId, String bindIP, int amount, String retcallUrl){
        this.isNull();
        if (customerId==null||customerId.trim().equals("")){throw new NullPointerException("customerId is null");}
        if(bindIP==null){throw new NullPointerException("bindIP is null");}
        if (amount<100){throw new LotteryApiException("amount must be greater than 100");}
        if (retcallUrl==null){throw new NullPointerException("retcallUrl is null");}

        if (extra!=null&&!extra.trim().equals("")){
            params.put("extra",extra);
        }
        params.put("amount",amount);
        params.put("customerId",customerId);
        params.put("bindIP",bindIP);
        params.put("retcallUrl",retcallUrl);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_CREATEADVANCETOKEN_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<CreateAdvanceTokenResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }


    /**
     * 获取提现记录
     * @param customerId    自定义用户id
     * @param currentPage   当前页数
     * @param showCount     每页显示条数
     * @return jsonObject
     */
    public ResultResponse<GetWithdrawalListResponse> getWithdrawalList(String customerId, int currentPage, int showCount){
        this.isNull();
        if (customerId==null||customerId.trim().equals("")){throw new NullPointerException("customerId is null");}
        if (currentPage<1){currentPage=1;}
        if (showCount<1){
            if (showCount>20){throw new LotteryApiException("showCount can't  greater than 20");}
            showCount=10;
        }

        params.put("customerId",customerId);
        params.put("currentPage",currentPage);
        params.put("showCount",showCount);

        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETWITHDRAWALLIST_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetWithdrawalListResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }

    /**
     *
     * @param type 类型 0为入账，1为出账
     * @return
     * @throws LotteryApiException
     */
    public ResultResponse<GetAccountDetailResponse> getAccountDetail(int type) {
        isNull();
        if (type!=0 &&type!=1){
            throw new LotteryApiException("not find type");
        }
        params.put("type",type);
        params=LotteryUtil.getPostParams(params,apiConfig.getSignkey());
        try {
            result=this.httpClientService.execute(ApiConstant.HTTP_GETACCOUNTDETAIL_URL,params);
            return JSON.parseObject(result,new TypeReference<ResultResponse<GetAccountDetailResponse>>(){});
        }catch (Exception e){
            throw new LotteryApiException(e);
        }
    }

    /**
     * 判断当前的apiConfig和httpClientService是否为空
     */
    private void isNull(){
        if (httpClientService==null){throw new NullPointerException("HttpClientService is null");}
        if (apiConfig==null){throw new NullPointerException("ApiConfig is null");}
        if (apiConfig.getAppId()==null){throw new NullPointerException("appId is null!");}
        if (apiConfig.getSignkey()==null){throw new NullPointerException("signKey is null");}
    }
}
