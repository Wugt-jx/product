package com.jhkj.demo3.api;


/**
 * Created by wgt on 2017/3/27.
 */
public class ApiConfig {

    private String appId;       //用户Id
    private String securekey;   //用户私钥
    private String signkey;     //签名钥

    public ApiConfig(String appId, String securekey, String signkey) {
        this.appId = appId;
        this.securekey = securekey;
        this.signkey = signkey;
    }

    public ApiConfig() {
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSignkey() {
        return signkey;
    }

    public void setSignkey(String signkey) {
        this.signkey = signkey;
    }

    public String getSecurekey() {
        return securekey;
    }

    public void setSecurekey(String securekey) {
        this.securekey = securekey;
    }


}
