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

    public static String getNonceStr(int length){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String headUrl(ApiConfig apiConfig){
        String headUrl="sign="+apiConfig.getSign()+"&"
                +"appId="+apiConfig.getAppId()+"&"
                +"nonceStr="+apiConfig.getNonceStr()+"&"
                +"timestamp="+apiConfig.getTimestamp();
        return headUrl;
    }

    protected static String getSign(String str,String key){
        str=str+"&key="+key;
        System.out.println(str);
        return SecureUtil.md5(str,"utf-8").toUpperCase();
    }

    /*protected static String getSign(String appId,String nonceStr,Long timeStamp,String key){
        if (appId==null||nonceStr==null||timeStamp==null||key==null){
            return "";
        }
        String signTemp="appid="+appId+
                "&nonce_str="+nonceStr+
                "×tamp="+timeStamp+
                "&key="+key;
        System.out.println(signTemp);
        return SecureUtil.md5(signTemp,"utf-8").toUpperCase();
    }*/


    //获取调用getSignKey的签名
    /*public static String getSignKey(String appId,String key){
        String signTemp="appid="+appId+
                "&nonce_str="+LotteryUtil.getNonceStr(12)+
                "×tamp="+LotteryUtil.getTimeStamp()+
                "&key="+key;
        return SecureUtil.md5(signTemp,"utf-8").toUpperCase();
    }*/
}
