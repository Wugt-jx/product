package com.jhkj.demo3;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * Created by wgt on 2017/3/25.
 */
public class HttpClientService implements IHttpClientService {

    private HttpClient httpClient;
    private HttpPost post;
    private HttpResponse response;

    public HttpClientService() {
    }

    public String execute(String urlName)throws Exception{


        System.out.println(urlName);
        httpClient=new DefaultHttpClient();
        post=new HttpPost(urlName);
        response=httpClient.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode()==200){
            System.out.println(EntityUtils.toString(response.getEntity()));
            return EntityUtils.toString(response.getEntity(),"utf-8");
        }else{
            return "请求失败！";
        }
    }
}
