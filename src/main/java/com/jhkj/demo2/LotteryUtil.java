package com.jhkj.demo2;

import com.xiaoleilu.hutool.util.SecureUtil;

import java.util.Random;

/**
 * Created by wgt on 2017/3/27.
 */
public class LotteryUtil {

    //private static Logger logger= LoggerFactory.getLogger(LotteryUtil.class);

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
        String headUrl="sign="+apiConfig.getSignkey()+"&"
                +"appId="+apiConfig.getAppId()+"&"
                +"nonceStr="+apiConfig.getNonceStr()+"&"
                +"timestamp="+apiConfig.getTimestamp();
        return headUrl;
    }

    protected static String getSign(String str,String key){
        str=str+"&key="+key;
        //logger.info("signtemp:{}",str);
        System.out.println("signtemp:"+str);
        return SecureUtil.md5(str,"utf-8").toUpperCase();
    }
}
