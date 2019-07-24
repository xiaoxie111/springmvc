package com.service;

import com.bean.WorkflowBusiness;
import com.dao.WorkflowBusinessDao;
import com.dao.WorkflowNodeDao;
import com.util.AboutTime;
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

    @Autowired
    AboutTime aboutTime;

    public String addWorkflowBusiness(String workflowId, String userId) {
        List<Map<String, Object>> workflowNodeList = workflowNodeDao.getWorkflowNodeList(workflowId);
        String nodes = "";
        for (Map<String, Object> map : workflowNodeList) {
            String node = (String) map.get("DEPTID");
            nodes += (node + ",");
        }
        nodes = nodes.substring(0, nodes.length() - 1);
        WorkflowBusiness workflowBusiness = new WorkflowBusiness();
        workflowBusiness.setUserId(userId);
        workflowBusiness.setNodes(nodes);
        workflowBusiness.setCjsj(aboutTime.getNowTime());
        workflowBusiness.setXgsj(aboutTime.getNowTime());
        workflowBusiness.setWorkflowId(workflowId);
        workflowBusiness.setTaskState("0");
        return workflowBusinessDao.addWorkflowBusiness(workflowBusiness);
    }

    public List<Map<String, Object>> getWorkflowBusinessList(String workflowId, String taskState, String userId, String orderName, String order) {
        return workflowBusinessDao.getWorkflowBusinessList(workflowId, taskState, userId, orderName, order);
    }


    public String updateWorkflowBusiness(String id) {
        WorkflowBusiness workflowBusiness = new WorkflowBusiness();
        workflowBusiness.setWorkflowId(id);
        workflowBusiness.setTaskState("1");
        workflowBusiness.setXgsj(aboutTime.getNowTime());
        return workflowBusinessDao.updateWorkflowBusiness(workflowBusiness);
    }

}
