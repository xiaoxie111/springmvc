package com.bean;

public class Workflow {
    private Integer id;
    private String workflow_name;
    private String workflow_desc;

    public Workflow() {
    }

    public Workflow(Integer id, String workflow_name, String workflow_desc) {
        this.id = id;
        this.workflow_name = workflow_name;
        this.workflow_desc = workflow_desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkflow_name() {
        return workflow_name;
    }

    public void setWorkflow_name(String workflow_name) {
        this.workflow_name = workflow_name;
    }

    public String getWorkflow_desc() {
        return workflow_desc;
    }

    public void setWorkflow_desc(String workflow_desc) {
        this.workflow_desc = workflow_desc;
    }
}
