package com.jhkj.demo2;


/**
 * Created by wgt on 2017/3/27.
 */
public class ApiConfig {

    private String appId;
    private String signkey;

    public ApiConfig(String appId, String signkey) {
        this.appId = appId;
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
}
