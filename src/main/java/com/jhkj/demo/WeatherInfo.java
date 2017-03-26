package com.jhkj.demo;

import java.io.Serializable;

/**
 * Created by wgt on 2017/3/24.
 */
public class WeatherInfo implements Serializable{


    private static final long serialVersionUID = 8861548013879272168L;
    private Integer cityid;
    private String city;
    private String ptime;
    private String weather;
    private String temp1;
    private String temp2;
    private String img1;
    private String img2;

    public WeatherInfo() {
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "cityid=" + cityid +
                ", city='" + city + '\'' +
                ", ptime='" + ptime + '\'' +
                ", weather='" + weather + '\'' +
                ", temp1='" + temp1 + '\'' +
                ", temp2='" + temp2 + '\'' +
                ", img1='" + img1 + '\'' +
                ", img2='" + img2 + '\'' +
                '}';
    }
}
