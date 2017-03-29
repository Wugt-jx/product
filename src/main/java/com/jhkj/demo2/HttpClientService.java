package com.jhkj.demo2;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by wgt on 2017/3/25.
 */
public class HttpClientService implements IHttpClientService {

    private HttpClient httpClient;
    private HttpPost post;
    private HttpResponse response;

    //private static Logger logger= LoggerFactory.getLogger(HttpClientService.class);


    public HttpClientService() {
    }


    public JSONObject execute(String urlName)throws Exception{

        System.out.println("httpURL:"+urlName);
        httpClient=new DefaultHttpClient();
        post=new HttpPost(urlName);
        response=httpClient.execute(post);
        if (response.getStatusLine().getStatusCode()==200){
            String result=EntityUtils.toString(response.getEntity());
            return JSONObject.parseObject(result);
        }else{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("code",response.getStatusLine().getStatusCode());
            jsonObject.put("msg","请求失败！");
            return jsonObject;
        }
    }
}