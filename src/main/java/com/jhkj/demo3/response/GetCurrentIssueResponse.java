package com.jhkj.demo3.response;

import com.jhkj.demo3.domain.CurrentIssue_Issue;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetCurrentIssueResponse {

    private CurrentIssue_Issue issue;

    public GetCurrentIssueResponse() {
    }

    public CurrentIssue_Issue getIssue() {
        return issue;
    }

    public void setIssue(CurrentIssue_Issue issue) {
        this.issue = issue;
    }
}
