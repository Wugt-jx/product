package com.jhkj.demo2;

import com.xiaoleilu.hutool.util.SecureUtil;

import java.util.Random;

/**
 * Created by wgt on 2017/3/27.
 */
public class LotteryUtil {


    public static Long getTimeStamp(){
        return System.currentTimeMillis()/1000;
    }

    public static String getNonceStr(){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


    protected static String getSign(String str,String key){
        str=str+"&key="+key;
        System.out.println("signtemp:"+str);
        return SecureUtil.md5(str,"utf-8").toUpperCase();
    }
}
