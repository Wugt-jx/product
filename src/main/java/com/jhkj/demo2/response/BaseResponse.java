package com.jhkj.demo2.response;

/**
 * Created by wgt on 2017/4/10.
 */
public class BaseResponse {
    private String code;
    private String msg;

    public BaseResponse() {
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
}
