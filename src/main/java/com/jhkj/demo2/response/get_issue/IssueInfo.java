package com.jhkj.demo2.response.get_issue;

/**
 * Created by wgt on 2017/4/10.
 */
public class IssueInfo {
    private String issue;
    private String lotteryNums;
    private Integer status;
    private String awardTime;
    private String beginTime;
    private String endTime;
    private String pool;

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getLotteryNums() {
        return lotteryNums;
    }

    public void setLotteryNums(String lotteryNums) {
        this.lotteryNums = lotteryNums;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(String awardTime) {
        this.awardTime = awardTime;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public IssueInfo() {

    }
}
