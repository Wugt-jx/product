package com.jhkj.demo2.service;

import com.jhkj.demo2.response.get_currentIssue.GetcurrentIssueResponse;
import junit.framework.TestCase;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetCurrentIssueServiceTest extends TestCase {
    public void testRequest() throws Exception {
        ApiConfig.setAppId("12345678912");
        ApiConfig.setSecureKey("4444325gdfgwer545df");
        ApiConfig.setSignKey("10ed4f639873ccafdd2e25471231b614");
        GetCurrentIssueService service=new GetCurrentIssueService();
        GetcurrentIssueResponse response=service.request(201);
        System.out.println(response);
    }

}