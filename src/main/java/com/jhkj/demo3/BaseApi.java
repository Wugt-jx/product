package com.jhkj.demo3;

/**
 * Created by wgt on 2017/3/25.
 */
public class BaseApi {

    private APIConfig apiConfig;
    private IHttpClientService httpClientService;

    public BaseApi(APIConfig apiConfig) {
        this.apiConfig = apiConfig;
        httpClientService=new HttpClientService();
    }

    public String getSignKey()throws Exception{
        StringBuilder sb_url=new StringBuilder(ConfigConstant.HTTP_URL+ConfigConstant.HTTP_GETTOKEN+"?");
        sb_url.append(apiConfig.getSign()+"&")
                .append(apiConfig.getAppId()+"&")
                .append(apiConfig.getNonceStr()+"&")
                .append(apiConfig.getTimestamp());
        return  this.httpClientService.execute(sb_url.toString());
    }


    public void setApiConfig(APIConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    public APIConfig getApiConfig() {
        return apiConfig;
    }
}
