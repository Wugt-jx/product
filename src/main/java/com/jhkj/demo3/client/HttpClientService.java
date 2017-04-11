package com.jhkj.demo3.client;

/**
 * Created by Administrator on 2017/3/31.
 */

import com.jhkj.demo3.constant.ApiConstant;
import com.jhkj.demo3.exception.LotteryApiException;
import com.jhkj.demo3.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientService {

    private static HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    private static Log logger=new Log(LoggerFactory.getLogger(HttpClientService.class));

    public String execute(String url, Map<String, Object> params) throws IOException {
        CloseableHttpClient httpClient=httpClientBuilder.build();

        if (url==null||url.trim().equals("")){
            throw new NullPointerException("post url is null");
        }
        logger.i("http request url:"+url);


        List<NameValuePair> pairs = null;
        if (params != null && !params.isEmpty()) {
            pairs = new ArrayList<NameValuePair>(params.size());
            for (String key : params.keySet()) {
                logger.i("http request parameter{"+key+":"+params.get(key).toString()+"}");
                pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
        }

        HttpPost httpPost= new HttpPost(url);
        if (pairs != null && pairs.size() > 0) {
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, ApiConstant.CHARSET));
        }

        CloseableHttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode != 200) {
            httpPost.abort();
            throw new LotteryApiException("response statusCode is "+statusCode,new LotteryApiException("\n"+EntityUtils.toString(response.getEntity())));
        }
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            throw new LotteryApiException("the request success,but no body");
        }
        String result = EntityUtils.toString(entity, ApiConstant.CHARSET);
        logger.i("response body :"+result);
        EntityUtils.consume(entity);
        response.close();

        return result;
    }
}
