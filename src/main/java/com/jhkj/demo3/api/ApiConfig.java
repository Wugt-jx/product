package com.jhkj.demo3.api;


/**
 * Created by wgt on 2017/3/27.
 */
public class ApiConfig {

    private String appId;
    private String securekey;
    private String signkey;

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
