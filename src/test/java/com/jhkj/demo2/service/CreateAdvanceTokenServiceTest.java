package com.jhkj.demo2.service;

import com.jhkj.demo2.response.create_advanceToken.CreateAdvanceTokenResponse;
import junit.framework.TestCase;

/**
 * Created by wgt on 2017/4/11.
 */
public class CreateAdvanceTokenServiceTest extends TestCase {
    public void testRequest() throws Exception {
        ApiConfig.setAppId("12345678912");
        ApiConfig.setSecureKey("4444325gdfgwer545df");
        ApiConfig.setSignKey("10ed4f639873ccafdd2e25471231b614");
        CreateAdvanceTokenService service=new CreateAdvanceTokenService();
        CreateAdvanceTokenResponse response=service.request("asdbaj","dbasjk","127.0.0.1",100,"www.baidu.com");
        System.out.println(response);
    }

}