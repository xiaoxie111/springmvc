package com.service;

import com.dao.WorkflowBusinessDao;
import com.dao.WorkflowNodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkflowBusinessService {

    @Autowired
    WorkflowBusinessDao workflowBusinessDao;

    @Autowired
    WorkflowNodeDao workflowNodeDao;

    public void addWorkflowBusiness(String workflowId, String userId) {
        List<Map<String, Object>> workflowNodeList = workflowNodeDao.getWorkflowNodeList(workflowId);
        String nodes = "";
        for (Map<String, Object> map : workflowNodeList) {
            String node = (String) map.get("DEPTID");
            nodes += (node + ",");
        }
        nodes = nodes.substring(0, nodes.length() - 1);
        workflowBusinessDao.addWorkflowBusiness(nodes, userId);
    }

}
