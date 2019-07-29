package com.service;

import com.dao.WorkflowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkflowService {

    @Autowired
    WorkflowDao workflowDao;

    public String addWorkflow(String workflow_name, String workflow_desc) {
        return workflowDao.addWorkflow(workflow_name, workflow_desc);
    }

    /**
     * 流程列表
     *
     * @param workfId
     * @param workflow_name
     * @param workflow_desc
     * @param orderName
     * @param order
     * @return
     */
    public List<Map<String, Object>> getWorkflowList(String workfId, String workflow_name, String workflow_desc, String orderName, String order,String effect) {
        List<Map<String, Object>> list = workflowDao.getWorkflowList(workfId, workflow_name, workflow_desc, orderName, order, effect);
        return list;
    }
}
