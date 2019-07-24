package com.controller;

import com.service.WorkflowBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("workflowBusiness")
public class WorkflowBusinessController {

    @Autowired
    WorkflowBusinessService workflowBusinessService;


    /**
     * 新增流程业务
     *
     * @param workflowId
     * @param userId
     * @return
     */
    @RequestMapping("addWorkflowBusiness")
    @ResponseBody
    public String addWorkflowBusiness(String workflowId, String userId) {
        return workflowBusinessService.addWorkflowBusiness(workflowId, userId);
    }

    /**
     * 查看业务流程
     *
     * @param workflowId
     * @param taskState
     * @param userId
     * @param orderName
     * @param order
     * @return
     */
    @RequestMapping("getWorkflowBusinessList")
    @ResponseBody
    public List<Map<String, Object>> getWorkflowBusinessList(String workflowId, String taskState, String userId, String orderName, String order) {
        return workflowBusinessService.getWorkflowBusinessList(workflowId, taskState, userId, orderName, order);
    }

}
