package com.bean;

import java.sql.Timestamp;

public class BusinessDetails {
    private Integer id;
    private String userId;
    private String nodes;
    private String steps;
    private String nodeId;
    private String nodeDetailsId;
    private Timestamp cjsj;
    private Timestamp xgsj;
    private String operation;
    private String businessId;

    public BusinessDetails() {
    }

    public BusinessDetails(Integer id, String userId, String nodes, String steps, String nodeId, String nodeDetailsId, Timestamp cjsj, Timestamp xgsj, String operation, String businessId) {
        this.id = id;
        this.userId = userId;
        this.nodes = nodes;
        this.steps = steps;
        this.nodeId = nodeId;
        this.nodeDetailsId = nodeDetailsId;
        this.cjsj = cjsj;
        this.xgsj = xgsj;
        this.operation = operation;
        this.businessId = businessId;
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

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeDetailsId() {
        return nodeDetailsId;
    }

    public void setNodeDetailsId(String nodeDetailsId) {
        this.nodeDetailsId = nodeDetailsId;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
