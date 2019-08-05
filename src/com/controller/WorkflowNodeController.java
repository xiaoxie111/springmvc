package com.controller;

import com.service.WorkflowNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 流程详情
 */
@Controller
@RequestMapping("workflowNode")
public class WorkflowNodeController {

    @Autowired
    WorkflowNodeService workflowNodeService;

    /**
     * 流程详情列表
     *
     * @param workflowId
     * @return
     */
    @RequestMapping("getWorkflowNodeList")
    @ResponseBody
    public List<Map<String, Object>> getWorkflowNodeList(String workflowId) {
        return workflowNodeService.getWorkflowNodeList(workflowId);
    }
}
