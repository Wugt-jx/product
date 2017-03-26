package com.jhkj.test;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by wgt on 2017/3/24.
 */
public class Client {

    public static String sengGet(String url){
        String result=null;
        HttpClient httpClient=new DefaultHttpClient();
        HttpGet get=new HttpGet(url);
        InputStream in=null;
        try {
            HttpResponse response=httpClient.execute(get);
            HttpEntity entity=response.getEntity();
            if (entity!=null){
                entity=new BufferedHttpEntity(entity);
                in=entity.getContent();
                byte[]read=new byte[1024];
                byte[] all=new byte[0];
                int num;
                while ((num=in.read(read))>0){
                    byte[]temp=new byte[all.length+num];
                    System.arraycopy(all,0,temp,0,all.length);
                    System.arraycopy(read,0,temp,all.length,num);
                    all=temp;
                }
                result=new String(all,"utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in!=null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String result=sengGet("http://www.baidu.com");
        System.out.println(result);
    }
}
