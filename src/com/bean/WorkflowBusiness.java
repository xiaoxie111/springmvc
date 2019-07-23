package com.bean;

import java.sql.Timestamp;

public class WorkflowBusiness {
    private Integer id;
    private String userId;
    private String nodes;
    private String steps;
    private Timestamp cjsj;

    public WorkflowBusiness() {
    }

    public WorkflowBusiness(Integer id, String userId, String nodes, String steps, Timestamp cjsj) {
        this.id = id;
        this.userId = userId;
        this.nodes = nodes;
        this.steps = steps;
        this.cjsj = cjsj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Timestamp getCjsj() {
        return cjsj;
    }

    public void setCjsj(Timestamp cjsj) {
        this.cjsj = cjsj;
    }
}
