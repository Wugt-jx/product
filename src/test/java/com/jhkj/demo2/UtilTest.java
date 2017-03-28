package com.jhkj.demo2;

import junit.framework.TestCase;

/**
 * Created by wgt on 2017/3/27.
 */
public class UtilTest extends TestCase {

    public void testGetTimeStamp() throws Exception {
        System.out.println(LotteryUtil.getTimeStamp());
    }

    public void testGetNonceStr() throws Exception {
        System.out.println(LotteryUtil.getNonceStr(32));
    }


    public void testGetSignKey()throws Exception{
        //System.out.println(LotteryUtil.getSignKey());
    }
}