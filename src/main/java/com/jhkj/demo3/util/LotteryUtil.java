package com.jhkj.demo3.util;

import com.xiaoleilu.hutool.util.SecureUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * Created by wgt on 2017/3/27.
 */
public class LotteryUtil {

    private static Log log= LogFactory.getLog(LotteryUtil.class);

    /**
     * 获取时间戳
     * @return
     */
    public static Long getTimeStamp(){
        return System.currentTimeMillis()/1000;
    }

    /**
     * 获取随机字符串
     * @return
     */
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

    /**
     * 获取签名
     * @return
     */
    public static Map<String,Object> getPostParams(Map<String, Object> params, String signKey){
        params.put("nonceStr",getNonceStr());
        params.put("timestamp",getTimeStamp());

        Set<String>keys=params.keySet();
        List<String> paramskey=orderKey(keys);

        StringBuilder sb_sign=new StringBuilder();
        for(int i=0;i<paramskey.size();i++){
            sb_sign.append(paramskey.get(i)+"="+params.get(paramskey.get(i)).toString()+"&");
        }
        sb_sign.append("key="+signKey);
        String sign = SecureUtil.md5(sb_sign.toString(),"utf-8").toUpperCase();

        log.info("create sign:"+sign);
        params.put("sign",sign);
        return params;
    }


    /**
     * 排序
     * @param keySet
     * @return
     */
    private static List<String> orderKey(Set<String>keySet){
        List<String>keys=new ArrayList<String>();
        Iterator<String>keyI=keySet.iterator();
        while (keyI.hasNext()){
            keys.add(keyI.next());
        }
        for (int i = 0; i < keys.size() - 1; i++) {
            for (int j = 0; j < keys.size() - i -1; j++) {
                String pre = keys.get(j);
                String next = keys.get(j+1);
                if(isMoreThan(pre, next)){
                    String temp = pre;
                    keys.set(j,next);
                    keys.set(j+1,temp);
                }
            }
        }
        return keys;
    }


    /**
     * 按照ASCII对比两个字符串的大小
     */
    private static boolean isMoreThan(String pre, String next){
        if(null == pre || null == next || "".equals(pre) || "".equals(next)){
            return false;
        }

        char[] c_pre = pre.toCharArray();
        char[] c_next = next.toCharArray();

        int minSize = Math.min(c_pre.length, c_next.length);

        for (int i = 0; i < minSize; i++) {
            if((int)c_pre[i] > (int)c_next[i]){
                return true;
            }else if((int)c_pre[i] < (int)c_next[i]){
                return false;
            }
        }
        if(c_pre.length > c_next.length){
            return true;
        }

        return false;
    }
}
