package com.jhkj.demo2;

import junit.framework.TestCase;


/**
 * Created by wgt on 2017/3/28.
 */
public class LotteryApiTest extends TestCase {

    ApiConfig apiConfig=new ApiConfig("12345678912","4d0828ab82956f80f7f57549567b3902");
    ILotteryApi lotteryApi=new LotteryApi(apiConfig);

    /*public void testGetSignKey() throws Exception {
        lotteryApi.getSignKey();
    }*/

    public void testCreateLotteryEx() throws Exception {
        lotteryApi.createLotteryEx(1,200,"wgtqqqq","adsbvfajabda");
    }
}