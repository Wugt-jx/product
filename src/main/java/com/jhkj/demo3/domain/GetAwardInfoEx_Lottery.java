package com.jhkj.demo3.domain;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetAwardInfoEx_Lottery implements Serializable {

    private static final long serialVersionUID = -5766589752728582183L;
    private Integer multi;
    private String issue;
    private String lotteryNums;
    private String flowid;
    private String voteNums;
    private Integer amount;
    private String orderNo;
    private Integer gameType;
    private Integer seqNo;
    private Integer voteType;
    private String customerId;


    public GetAwardInfoEx_Lottery() {
    }

    public Integer getMulti() {
        return multi;
    }

    public void setMulti(Integer multi) {
        this.multi = multi;
    }

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

    public String getFlowid() {
        return flowid;
    }

    public void setFlowid(String flowid) {
        this.flowid = flowid;
    }

    public String getVoteNums() {
        return voteNums;
    }

    public void setVoteNums(String voteNums) {
        this.voteNums = voteNums;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getVoteType() {
        return voteType;
    }

    public void setVoteType(Integer voteType) {
        this.voteType = voteType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
