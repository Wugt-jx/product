package com.jhkj.demo2.service;

import junit.framework.TestCase;

/**
 * Created by wgt on 2017/4/11.
 */
public class EncashToAccountServiceTest extends TestCase {
    public void testRequest() throws Exception {
        ApiConfig.setAppId("12345678912");
        ApiConfig.setSecureKey("4444325gdfgwer545df");
        ApiConfig.setSignKey("10ed4f639873ccafdd2e25471231b614");
        EncashToAccountService service=new EncashToAccountService();
        service.request(100,"dbasjk");
    }

}