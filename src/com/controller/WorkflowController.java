package com.controller;

import com.service.WorkflowNodeService;
import com.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("workflow")
public class WorkflowController {

    @Autowired
    WorkflowService workflowService;

    @Autowired
    WorkflowNodeService workflowNodeService;

    @RequestMapping("addWorkflow")
    @ResponseBody
    public String addWorkflow(String nodes, String workflow_name, String workflow_desc) {
        if (nodes != null && !nodes.isEmpty()) {
            List<Map<String, Object>> list = workflowService.getWorkflowList(null, workflow_name, null, "cjsj", "desc", "1");
            if (list == null || list.size() == 0) {
                String juest = workflowService.addWorkflow(workflow_name, workflow_desc);
                if (juest.equals("1")) {
                    List<Map<String, Object>> workflowList = workflowService.getWorkflowList(null, null, null, "cjsj", "desc", null);
                    if (workflowList != null && workflowList.size() > 0) {
                        Map<String, Object> workflowMap = workflowList.get(0);
                        return workflowNodeService.addWorkflow(nodes, String.valueOf(workflowMap.get("ID")));
                    }
                }
            }
        }
        return "0";
    }

    @RequestMapping("getWorkflowList")
    @ResponseBody
    public List<Map<String, Object>> getWorkflowList(String workflowId, String workflow_name, String workflow_desc, String orderName, String order) {
        List<Map<String, Object>> list = workflowService.getWorkflowList(workflowId, workflow_name, workflow_desc, orderName, order, "1");
        return list;
    }
}
