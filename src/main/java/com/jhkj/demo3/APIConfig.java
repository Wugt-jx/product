package com.jhkj.demo3;

/**
 * Created by wgt on 2017/3/25.
 */
public class APIConfig {

    private String  appId;
    private String  sign;
    private String  nonceStr;
    private String  timestamp;

    public APIConfig() {
    }

    public APIConfig(String appId, String sign, String nonceStr, String timestamp) {
        this.appId = appId;
        this.sign = sign;
        this.nonceStr = nonceStr;
        this.timestamp = timestamp;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
