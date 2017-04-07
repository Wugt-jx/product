package com.jhkj.demo3.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import junit.framework.TestCase;

/**
 * Created by wgt on 2017/4/7.
 */
public class ResultResponseTest extends TestCase {
    String str="{\n" +
            "    \"data\": {\n" +
            "        \"accountDetails\": [\n" +
            "            {\n" +
            "                \"amount\": 10,\n" +
            "                \"createTime\": 1473667995074,\n" +
            "                \"orderNo\": \"2h9pqbn8a3sjsaz2\",\n" +
            "                \"customerId\": \"1\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"code\": \"00000\",\n" +
            "    \"msg\": \"ok\"\n" +
            "}";

    public void test() throws Exception {
        JSONObject jsonObject=JSON.parseObject(str);
        ResultResponse response=JSON.parseObject(jsonObject.toJSONString(),new TypeReference<ResultResponse<GetAccountDetailResponse>>(){});
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        System.out.println(response.getData());
    }
}