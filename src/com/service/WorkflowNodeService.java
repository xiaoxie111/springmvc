package com.service;

import com.dao.WorkflowNodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkflowNodeService {

    @Autowired
    WorkflowNodeDao workflowNodeDao;

    public String addWorkflow(String deptIds, String workflowId) {
        String[] deptIdList = deptIds.split(",");
        int j = 0;
        for (int i = 0; i < deptIdList.length; i++) {
            j += workflowNodeDao.addWorkflowNode(deptIdList[i], String.valueOf(i), workflowId);
        }
        return String.valueOf(j);
    }

    public List<Map<String, Object>> getWorkflowNodeList(String workflowId) {
        return workflowNodeDao.getWorkflowNodeList(workflowId);
    }
}
