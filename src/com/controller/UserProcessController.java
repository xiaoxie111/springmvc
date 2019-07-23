package com.controller;

import com.bean.UserProcess;
import com.service.UserProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("userProcess")
public class UserProcessController {

    @Autowired
    UserProcessService userProcessService;

    /**
     * 根据用户查询用户流程表
     * @param userId
     * @return
     */
    @RequestMapping("getUserProcessList")
    @ResponseBody
    public List<Map<String,Object>> getUserProcessList(String userId){
        if (userId!=null){
            return userProcessService.getUserProcessList(userId);
        }
        return null;
    }

    /**
     * 新增流程
     *
     * @param userId
     */
    @RequestMapping("addUserProcess")
    @ResponseBody
    public String addUserProcess(String status, String userId, String documentRecordId, String rejectInformation){
        if (userId != null){
            return userProcessService.addUserProcess(status, userId, documentRecordId, rejectInformation);
        }
        return "0";
    }

    /**
     * 根据流程Id获取流程详细信息
     *
     * @param processId
     * @return
     */
    @RequestMapping("getUserProcess")
    @ResponseBody
    public Map<String,Object> getUserProcess(String processId){
        return userProcessService.getUserProcess(processId);
    }
}
