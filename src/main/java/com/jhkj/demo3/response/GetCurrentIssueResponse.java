package com.jhkj.demo3.response;

import com.jhkj.demo3.domain.CurrentIssue_Issue;

import java.util.List;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetCurrentIssueResponse {

    private List<CurrentIssue_Issue> issue;

    public GetCurrentIssueResponse() {
    }

    public List<CurrentIssue_Issue> getIssue() {
        return issue;
    }

    public void setIssue(List<CurrentIssue_Issue> issue) {
        this.issue = issue;
    }
}
