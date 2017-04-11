package com.jhkj.demo2.service;

import com.jhkj.demo2.response.get_accountBalance.GetAccountBalanceResponse;
import junit.framework.TestCase;

/**
 * Created by wgt on 2017/4/11.
 */
public class GetAccountBalanceServiceTest extends TestCase {
    public void testRequest() throws Exception {
        ApiConfig.setAppId("12345678912");
        ApiConfig.setSecureKey("4444325gdfgwer545df");
        ApiConfig.setSignKey("10ed4f639873ccafdd2e25471231b614");
        GetAccountBalanceService service=new GetAccountBalanceService();
        GetAccountBalanceResponse response=service.request();
        System.out.println(response.getData().getBalance());
    }

}