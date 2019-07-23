package com.bean;

public class WorkflowNode {
    private Integer id;
    private String deptId;
    private String workflowOrder;

    public WorkflowNode() {
    }

    public WorkflowNode(Integer id, String deptId, String workflowOrder) {
        this.id = id;
        this.deptId = deptId;
        this.workflowOrder = workflowOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getWorkflowOrder() {
        return workflowOrder;
    }

    public void setWorkflowOrder(String workflowOrder) {
        this.workflowOrder = workflowOrder;
    }
}
