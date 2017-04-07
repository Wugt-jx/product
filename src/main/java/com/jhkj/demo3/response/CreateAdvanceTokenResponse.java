package com.jhkj.demo3.response;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class CreateAdvanceTokenResponse implements Serializable {
    private static final long serialVersionUID = 1548927317861122648L;
    private String token;

    public CreateAdvanceTokenResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
