package com.jhkj.demo2;


/**
 * Created by wgt on 2017/3/27.
 */
public class ApiConfig {

    private String  appId;                  //appId
    private String  signkey;                   //签名
    private String  nonceStr;               //随机生成字符串
    private Long  timestamp;                //时间戳


    public ApiConfig(String appId,String signkey) {
        this.appId=appId;
        this.nonceStr= LotteryUtil.getNonceStr(32);
        this.timestamp= LotteryUtil.getTimeStamp();
        this.signkey=signkey;
    }


    public boolean isNull(){
        if (this.appId==null||this.signkey==null||this.nonceStr==null||this.timestamp==null){
            return true;
        }
        return false;
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

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ApiConfig{" +
                "appId='" + appId + '\'' +
                ", sign='" + signkey + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
