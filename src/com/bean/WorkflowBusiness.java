package com.bean;

import java.sql.Timestamp;

public class WorkflowBusiness {
    private Integer id;
    private String userId;
    private String nodes;
    private Timestamp cjsj;
    private Timestamp xgsj;
    private String workflowId;
    private String taskState;

    public WorkflowBusiness() {
    }

    public WorkflowBusiness(Integer id, String userId, String nodes, Timestamp cjsj, Timestamp xgsj, String workflowId, String taskState) {
        this.id = id;
        this.userId = userId;
        this.nodes = nodes;
        this.cjsj = cjsj;
        this.xgsj = xgsj;
        this.workflowId = workflowId;
        this.taskState = taskState;
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

    public Timestamp getCjsj() {
        return cjsj;
    }

    public void setCjsj(Timestamp cjsj) {
        this.cjsj = cjsj;
    }

    public Timestamp getXgsj() {
        return xgsj;
    }

    public void setXgsj(Timestamp xgsj) {
        this.xgsj = xgsj;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }
}
