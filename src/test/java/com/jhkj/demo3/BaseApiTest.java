package com.jhkj.demo3;

import junit.framework.TestCase;

/**
 * Created by wgt on 2017/3/26.
 */
public class BaseApiTest extends TestCase {
    public void testGetToken() throws Exception {
        APIConfig apiConfig=new APIConfig();
        apiConfig.setSign("9A0A8659F005D6984697E2CA0A9CF3B7");
        apiConfig.setAppId("10000100");
        apiConfig.setNonceStr("bltaomo17ghesg9t3kpn7b412kql2gm8");
        apiConfig.setTimestamp("9A0A8659F005D6984697E2CA0A9CF3B7");
        BaseApi api=new BaseApi(apiConfig);

        String result=api.getSignKey();
        System.out.println(result);
    }

}