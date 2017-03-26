package com.jhkj.demo;

/**
 * Created by wgt on 2017/3/24.
 */
public class WeatherException extends RuntimeException{

    private Integer code;

    public WeatherException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
