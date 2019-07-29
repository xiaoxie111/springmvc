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
    BusinessDetailsService businessDetailsService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    AboutTime aboutTime;

    public String addWorkflowBusiness(String workflowId, String userId) {
        List<Map<String, Object>> workflowNodeList = workflowNodeDao.getWorkflowNodeList(workflowId);
        String nodes = "";
        for (Map<String, Object> map : workflowNodeList) {
            String node = String.valueOf(map.get("DEPTID"));
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
        String juest = workflowBusinessDao.addWorkflowBusiness(workflowBusiness);
        if ("1".equals(juest)) {
            String nodeId = String.valueOf(workflowNodeList.get(0).get("DEPTID"));
            List<Map<String, Object>> deptList = departmentService.getDepartmentList(nodeId, null);
            String deptname = String.valueOf(deptList.get(0).get("deptname"));
            List<Map<String, Object>> workflowBusinessList = workflowBusinessDao.getWorkflowBusinessList(workflowId, null, userId, "cjsj", "desc");
            String businessId = String.valueOf(workflowBusinessList.get(0).get("ID"));
            return businessDetailsService.addBusinessDetails(userId, nodes, "0", nodeId, deptname, "", businessId);
        }
        return juest;
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


