package com.jhkj.demo2;

import com.alibaba.fastjson.JSONObject;
import com.jhkj.demo3.api.ApiConfig;
import com.jhkj.demo3.api.ILotteryApi;
import com.jhkj.demo3.api.LotteryApi;
import junit.framework.TestCase;


/**
 * Created by wgt on 2017/3/28.
 */
public class LotteryApiTest extends TestCase {

    ApiConfig apiConfig=new ApiConfig("12345678912","11589ab946eb6a43336ac035d6f51080","");
    ILotteryApi lotteryApi=new LotteryApi(apiConfig);

    public void testrew() throws Exception {
        System.out.println("dasvh");
    }



    /*public void testGetSignKey() throws Exception {
        JSONObject jsonObject=lotteryApi.getSignKey();
        System.out.println(jsonObject);
    }*/


    //PASS
    /*public void testCreateLotteryEx() throws Exception {
        JSONObject jsonObject=lotteryApi.createLotteryEx(1,200,"wdsadasgtqqqq","gdvkaug");
        System.out.println(jsonObject);
    }*/

    //PASS
    public void testgetCurrentIssue() throws Exception {
        JSONObject result=lotteryApi.getCurrentIssue(201);
        System.out.println(result.toString());
    }

   // PASS
    /*public void testGetIssue() throws Exception {
        JSONObject jsonObject=lotteryApi.getIssue("2017002",1,10);
        System.out.println(jsonObject.toString());
    }*/

    // 因为未返还预期数据，测试结果未知
    /*public void testgetAwardInfoEx() throws Exception {
        JSONObject jsonObject=lotteryApi.getAwardInfoEx(null,1,10);
        System.out.println(jsonObject.toString());
    }*/


    //PASS
    /*public void testGetLotteryListByCustomerId() throws Exception {
        JSONObject jsonObject=lotteryApi.getLotteryListByCustomerId("wdsadasgtqqqq",1,5);
        System.out.println(jsonObject);
    }*/

    //PASS
    /*public void testGetLotteryListByOrderNo() throws Exception {
        JSONObject jsonObject=lotteryApi.getLotteryListByOrderNo(1,10,"fhdafgjhfb");
        System.out.println(jsonObject.toString());
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
    /*public void testGetWithdrawalList() throws Exception {
        JSONObject jsonObject = lotteryApi.getWithdrawalList("wgtqqqq", 1, 10);
        System.out.println(jsonObject);
    }*/

    //获取账号出入明细
   /* public void testGetAccountDetail() throws Exception {
        JSONObject jsonObject=lotteryApi.getAccountDetail(1);
        System.out.println(jsonObject);
    }*/
}