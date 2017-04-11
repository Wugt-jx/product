package com.jhkj.demo2;

import com.jhkj.demo3.api.ApiConfig;
import com.jhkj.demo3.api.LotteryApi;
import com.jhkj.demo3.domain.*;
import com.jhkj.demo3.response.*;
import junit.framework.TestCase;

import java.util.List;


/**
 * Created by wgt on 2017/3/28.
 */
public class LotteryApiTest extends TestCase {

    ApiConfig apiConfig=new ApiConfig("12345678912","4444325gdfgwer545df","10ed4f639873ccafdd2e25471231b614");
    LotteryApi lotteryApi=new LotteryApi(apiConfig);

    /*public void testrew() throws Exception {
        System.out.println("dasvh");
    }*/



    /*public void testGetSignKey() throws Exception {
        ResultResponse<GetSignKeyResponse>response=lotteryApi.getSignKey();
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        GetSignKeyResponse datas=response.getData();
        System.out.println(datas.getKey());
    }*/


    //PASS
   /* public void testCreateLotteryEx() throws Exception {
        ResultResponse<CreateLotteryExResponse>response=lotteryApi.createLotteryEx(1,100,"wgt","klobfa");
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        CreateLotteryExResponse data=response.getData();
        System.out.println(data.getCustomerId());
        System.out.println(data.getOrderNo());
        List<CreateLotteryEx_Lotterys> lotterys=data.getLotterys();
        for (CreateLotteryEx_Lotterys lottery:lotterys){
            System.out.println(lottery.getAmount());
            System.out.println(lottery.getFlowid());
            System.out.println(lottery.getGameType());
            System.out.println(lottery.getIssue());
            System.out.println(lottery.getMulti());
            System.out.println(lottery.getSeqNo());
            System.out.println(lottery.getVoteNums());
            System.out.println(lottery.getVoteType());
        }
    }*/

    //PASS
    public void testgetCurrentIssue() throws Exception {
       ResultResponse<GetCurrentIssueResponse>response =lotteryApi.getCurrentIssue(201);
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        GetCurrentIssueResponse data=response.getData();
        List<CurrentIssue_Issue>issue=data.getIssue();
        System.out.println(issue);
    }


   // PASS
    /*public void testGetIssue() throws Exception {
        ResultResponse<GetIssueResponse> response=lotteryApi.getIssue(null,1,10);
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        GetIssueResponse data=response.getData();
        List<GetIssue_Issue>issues=data.getIssues();
        for (GetIssue_Issue issue:issues){
            System.out.println(issue.getAwardTime());
            System.out.println(issue.getBeginTime());
            System.out.println(issue.getEndTime());
            System.out.println(issue.getIssue());
            System.out.println(issue.getStatus());
            System.out.println(issue.getLotteryNums());
            System.out.println(issue.getPool());
        }
    }*/

    // 因为未返还预期数据，测试结果未知
    /*public void testgetAwardInfoEx() throws Exception {
        ResultResponse<GetAwardInfoExResponse>response=lotteryApi.getAwardInfoEx("2016082",1,5);
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        GetAwardInfoExResponse data=response.getData();
        List<GetAwardInfoEx_Lottery>lotterys=data.getLotterys();
        for (GetAwardInfoEx_Lottery lottery : lotterys){
            System.out.println(lottery.getAmount());
            System.out.println(lottery.getCustomerId());
            System.out.println(lottery.getFlowid());
            System.out.println(lottery.getGameType());
            System.out.println(lottery.getIssue());
            System.out.println(lottery.getMulti());
            System.out.println(lottery.getOrderNo());
            System.out.println(lottery.getSeqNo());
            System.out.println(lottery.getVoteNums());
            System.out.println(lottery.getVoteType());
            System.out.println(lottery.getLotteryNums());
        }
    }*/


    //PASS
    public void testGetLotteryListByCustomerId() throws Exception {
        System.out.println(System.currentTimeMillis());
        ResultResponse<GetLotteryListResponse>response=lotteryApi.getLotteryListByCustomerId("wgt",1,1);
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        GetLotteryListResponse data=response.getData();
        List<GetLotteryList_Lottery>lotterys=data.getLotterys();
        for (GetLotteryList_Lottery lottery:lotterys){
            System.out.println(lottery.getCreateTime());
            System.out.println(lottery.getAmount());
            System.out.println(lottery.getGameType());
            System.out.println(lottery.getIssue());
            System.out.println(lottery.getMulti());
            System.out.println(lottery.getSeqNo());
            System.out.println(lottery.getVoteNums());
            System.out.println("voteType="+lottery.getVoteType());
            System.out.println(lottery.getLotteryNums());
            System.out.println(lottery.getPrize());
            System.out.println(lottery.getGrade());
        }
        System.out.println(System.currentTimeMillis());
    }

    //PASS
    /*public void testGetLotteryListByOrderNo() throws Exception {

    }*/

    //PASS
    /*public void testGetAccountBalance() throws Exception {
        JSONObject jsonObject=lotteryApi.getAccountBalance();
        System.out.println(jsonObject.toString());
    }*/

    //PASS查看用户奖金余额
    /*public void testGetCustomerWinBalance() throws Exception {
        JSONObject jsonObject=lotteryApi.getCustomerWinBalance("wgtqqqq");
        System.out.println(jsonObject.toString());
    }*/

    //因该用户奖金余额为0，无法进行测试（404）
    /*public void testEncashToAccount() throws Exception {
        JSONObject jsonObject=lotteryApi.encashToAccount(1,"wgtqqqq");
        System.out.println(jsonObject);
    }*/

    //获取提现页面所需的token (404错误）
    /*public void testCreateAdvanceToken() throws Exception {
        JSONObject jsonObject=lotteryApi.createAdvanceToken("dadas","wgtqqqq",
                "116.22.135.122",200,"www.baidu.com");
        System.out.println(jsonObject);
    }*/

    //获取提现记录(404）
    public void testGetWithdrawalList() throws Exception {
        ResultResponse<GetWithdrawalListResponse> response = lotteryApi.getWithdrawalList("wgtqqqq", 1, 10);
    }

    //获取账号出入明细
   /* public void testGetAccountDetail() throws Exception {
        JSONObject jsonObject=lotteryApi.getAccountDetail(1);
        System.out.println(jsonObject);
    }*/
}