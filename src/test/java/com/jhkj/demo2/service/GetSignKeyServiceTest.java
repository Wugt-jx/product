package com.jhkj.demo2.service;

import com.jhkj.demo2.response.get_signkey.GetSignKeyResponse;
import junit.framework.TestCase;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetSignKeyServiceTest extends TestCase {


    public void testRequest() throws Exception {
        ApiConfig.setAppId("12345678912");
        ApiConfig.setSecureKey("4444325gdfgwer545df");

        GetSignKeyService service=new GetSignKeyService();
        GetSignKeyResponse result= service.request();
        System.out.println(result.getData().getKey());
    }

}