package com.jhkj.demo2.response.create_lotteryEX;

/**
 * Created by wgt on 2017/4/10.
 */
public class LotteryInfo {
    private String issue;
    private Integer multi;
    private String voteNums;
    private Integer amount;
    private String flowid;
    private Integer voteType;
    private Integer gameType;
    private Integer seqNo;

    public LotteryInfo() {
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

    public String getFlowid() {
        return flowid;
    }

    public void setFlowid(String flowid) {
        this.flowid = flowid;
    }

    public Integer getVoteType() {
        return voteType;
    }

    public void setVoteType(Integer voteType) {
        this.voteType = voteType;
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
}
