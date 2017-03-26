package com.jhkj.demo3;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by wgt on 2017/3/25.
 */
public class HttpClientServiceTest extends TestCase {


    public void testExecute() throws Exception {
        IHttpClientService httpClientService=new HttpClientService();
        httpClientService.execute("http://www.weather.com.cn/data/cityinfo/101010100.html");
    }

}