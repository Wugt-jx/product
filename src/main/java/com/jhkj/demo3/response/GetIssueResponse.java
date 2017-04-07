package com.jhkj.demo3.response;

import com.jhkj.demo3.domain.GetIssue_Issue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetIssueResponse implements Serializable{

    private static final long serialVersionUID = -8001849782768117733L;

    private List<GetIssue_Issue>issues;

    public GetIssueResponse() {
    }

    public List<GetIssue_Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<GetIssue_Issue> issues) {
        this.issues = issues;
    }
}
