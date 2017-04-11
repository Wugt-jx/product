package com.jhkj.demo3.response;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class ResultResponse<T extends Object> implements Serializable {

    private static final long serialVersionUID = 2324268540348642124L;

    private String code;    //响应头
    private String msg;     //响应信息
    private T  data;        //响应数据

    public ResultResponse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess(){
        return this.code != null && this.code.equals("0000");
    }
}
