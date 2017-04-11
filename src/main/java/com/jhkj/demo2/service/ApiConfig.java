package com.jhkj.demo2.service;


/**
 * Created by wgt on 2017/3/27.
 */
public class ApiConfig {
    private static String appId="";
    private static String secureKey="";
    private static String signKey="";

    public ApiConfig() {
    }

    public static String getAppId() {
        return appId;
    }

    public static void setAppId(String appId) {
        ApiConfig.appId = appId;
    }

    public static String getSecureKey() {
        return secureKey;
    }

    public static void setSecureKey(String secureKey) {
        ApiConfig.secureKey = secureKey;
    }

    public static String getSignKey() {
        return signKey;
    }

    public static void setSignKey(String signKey) {
        ApiConfig.signKey = signKey;
    }
}
