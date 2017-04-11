package com.jhkj.demo3.domain;

import java.io.Serializable;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetLotteryList_Lottery implements Serializable{

    private static final long serialVersionUID = -5527235244262825607L;
    private Integer amount;
    private String flowId;
    private Integer voteType;
    private Integer grade;
    private String lotteryNums;
    private Integer prize;
    private Integer seqNo;
    private Integer status;
    private String voteNums;
    private String createTime;
    private String issue;
    private Integer multi;
    private Integer gameType;

    public GetLotteryList_Lottery() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public Integer getVoteType() {
        return voteType;
    }

    public void setVoteType(Integer voteType) {
        this.voteType = voteType;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getLotteryNums() {
        return lotteryNums;
    }

    public void setLotteryNums(String lotteryNums) {
        this.lotteryNums = lotteryNums;
    }

    public Integer getPrize() {
        return prize;
    }

    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getVoteNums() {
        return voteNums;
    }

    public void setVoteNums(String voteNums) {
        this.voteNums = voteNums;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Integer getMulti() {
        return multi;
    }

    public void setMulti(Integer multi) {
        this.multi = multi;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }
}
