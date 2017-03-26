package com.jhkj.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by wgt on 2017/3/24.
 */
public class Test1 {

    public static void main(String args[]){
        HttpClient httpClient=new DefaultHttpClient();
        StringBuffer sb_url=new StringBuffer("http://cgi-test.lingqiancai.cc/cgi-api/v1/getCurrentIssue");

        HttpPost post=new HttpPost(sb_url.toString());
        try {
            HttpResponse response=httpClient.execute(post);
            if (response.getStatusLine().getStatusCode()==200){

                String result=EntityUtils.toString(response.getEntity());
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
