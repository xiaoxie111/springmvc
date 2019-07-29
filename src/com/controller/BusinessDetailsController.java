package com.controller;

import com.service.BusinessDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("businessDetails")
public class BusinessDetailsController {

    @Autowired
    BusinessDetailsService businessDetailsService;

    @RequestMapping("getBusinessDetailsList")
    @ResponseBody
    public List<Map<String, Object>> getBusinessDetailsList(String businessDetailsId, String userId, String deptId, String operation, String businessId, String orderName, String order) {
        return businessDetailsService.getBusinessDetailsList(businessDetailsId, userId, deptId, operation, businessId, orderName, order);
    }

    @RequestMapping("updateBusinessDetails")
    @ResponseBody
    public String updateBusinessDetails(String businessDetailsId,String businessId, String userId, String operation) {
        return businessDetailsService.updateBusinessDetails(businessDetailsId, businessId, userId, operation);
    }
}
