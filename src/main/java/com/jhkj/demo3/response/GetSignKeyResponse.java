package com.jhkj.demo3.response;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetSignKeyResponse implements Serializable {
    private static final long serialVersionUID = 5993994833200891603L;

    private String key;

    public GetSignKeyResponse() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

