package com.jhkj.demo2.response.get_issue;

import java.util.List;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetIssueData {
    private List<IssueInfo>issues;

    public GetIssueData() {
    }

    public List<IssueInfo> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueInfo> issues) {
        this.issues = issues;
    }
}
