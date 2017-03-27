package com.jhkj.demo2;

import junit.framework.TestCase;

/**
 * Created by wgt on 2017/3/28.
 */
public class ApiConfigTest extends TestCase {
    public void testGetAppId() throws Exception {
        ApiConfig apiConfig=new ApiConfig("12345678912","4444325gdfgwer545df");
        System.out.println(apiConfig.toString());
    }

}