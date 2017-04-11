package com.jhkj.demo2;

import com.jhkj.demo2.response.create_lotteryEX.CreateLotteryExResponse;
import junit.framework.TestCase;

/**
 * Created by wgt on 2017/4/11.
 */
public class LotterySDKTest extends TestCase {
    public void test() throws Exception {
        LotterySDK.initSDKConfigure("12345678912","4444325gdfgwer545df","10ed4f639873ccafdd2e25471231b614");
        CreateLotteryExResponse response=LotterySDK.createLotteryEx(1,100,"wgt","wgt110");
        System.out.println(response);
    }
}