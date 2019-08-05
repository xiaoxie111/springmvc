package com.service;

import com.dao.WorkflowDao;
import com.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkflowService {

    @Autowired
    WorkflowDao workflowDao;

    @Autowired
    WorkflowNodeService workflowNodeService;

    @Autowired
    CommonUtil commonUtil;

    public String addWorkflow(String nodes, String workflow_name, String workflow_desc) {
        String i = workflowDao.addWorkflow(workflow_name, workflow_desc);
        if (i.equals("1")) {
            List<Map<String, Object>> workflowList = getWorkflowList(null, null, null, "cjsj", "desc", null);
            Map<String, Object> workflowMap = commonUtil.getMapForList(workflowList);
            if (workflowMap != null && !workflowMap.isEmpty()) {
                return workflowNodeService.addWorkflow(nodes, String.valueOf(workflowMap.get("ID")));
            }
        }
        return "0";
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
    public List<Map<String, Object>> getWorkflowList(String workfId, String workflow_name, String workflow_desc, String orderName, String order, String effect) {
        List<Map<String, Object>> list = workflowDao.getWorkflowList(workfId, workflow_name, workflow_desc, orderName, order, effect);
        return list;
    }
}
