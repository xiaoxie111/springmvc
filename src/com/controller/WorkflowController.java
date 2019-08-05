package com.controller;

import com.service.WorkflowNodeService;
import com.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 流程表
 */
@Controller
@RequestMapping("workflow")
public class WorkflowController {

    @Autowired
    WorkflowService workflowService;

    @Autowired
    WorkflowNodeService workflowNodeService;

    /**
     * 新增流程
     *
     * @param nodes 节点
     *
     * @param workflow_name
     * @param workflow_desc
     * @return
     */
    @RequestMapping("addWorkflow")
    @ResponseBody
    public String addWorkflow(String nodes, String workflow_name, String workflow_desc) {
        // 部门所选为空，则不能新增
        if (nodes != null && !nodes.isEmpty()) {
            //effect  1 表示查询其流程节点表中有数据的
            List<Map<String, Object>> list = workflowService.getWorkflowList(null, workflow_name, null, "cjsj", "desc", "1");
            if (list == null || list.size() == 0) {
                String juest = workflowService.addWorkflow(nodes,workflow_name, workflow_desc);

            }
        }
        return "0";
    }

    /**
     * 流程列表
     *
     * @param workflowId
     * @param workflow_name
     * @param workflow_desc
     * @param orderName
     * @param order
     * @return
     */
    @RequestMapping("getWorkflowList")
    @ResponseBody
    public List<Map<String, Object>> getWorkflowList(String workflowId, String workflow_name, String workflow_desc, String orderName, String order) {
        List<Map<String, Object>> list = workflowService.getWorkflowList(workflowId, workflow_name, workflow_desc, orderName, order, "1");
        return list;
    }
}
