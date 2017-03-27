package com.jhkj.demo2;

import com.xiaoleilu.hutool.util.SecureUtil;

/**
 * Created by wgt on 2017/3/27.
 */
public class ApiConfig {

    private String  appId;                  //appId
    private String  sign;                   //签名
    private String  nonceStr;               //随机生成字符串
    private Long  timestamp;                //时间戳

    public ApiConfig(String appId,String signkey) {
        this.appId=appId;
        this.nonceStr=Util.getNonceStr(32);
        this.timestamp=Util.getTimeStamp();
        this.sign=getSign(signkey);
    }


    //获取调用接口的签名sign
    private String getSign(String signkey){
        if(this.appId==null){
            throw new NullPointerException("appid is null");
        }
        if (this.nonceStr==null){
            throw new NullPointerException("nonceStr is null");
        }
        if (this.timestamp==null){
            throw new NullPointerException("timeStamp is null");
        }
        if (signkey==null){
            throw new NullPointerException("signkey is null");
        }
        String signTemp="appid="+this.appId+
                "&nonce_str="+this.nonceStr+
                "×tamp="+this.timestamp.toString()+
                "&key="+signkey;
        System.out.println(signTemp);
        return SecureUtil.md5(signTemp,"utf-8").toUpperCase();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }



    @Override
    public String toString() {
        return "ApiConfig{" +
                "appId='" + appId + '\'' +
                ", sign='" + sign + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
