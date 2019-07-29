package com.service;

import com.bean.BusinessDetails;
import com.bean.WorkflowBusiness;
import com.dao.BusinessDetailsDao;
import com.dao.WorkflowBusinessDao;
import com.util.AboutTime;
import com.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class BusinessDetailsService {

    @Autowired
    BusinessDetailsDao businessDetailsDao;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    WorkflowBusinessDao workflowBusinessDao;

    @Autowired
    AboutTime aboutTime;

    @Autowired
    CommonUtil commonUtil;

    public String addBusinessDetails(String userId, String nodes, String steps, String nodeId, String nodeDetailsId, String operation, String businessId) {
        BusinessDetails businessDetails = setBusinessDetails(null, userId, nodes, steps, nodeId, nodeDetailsId, operation, businessId);
        return businessDetailsDao.addBusinessDetails(businessDetails);
    }

    public List<Map<String, Object>> getBusinessDetailsList(String businessDetailsId, String userId, String deptId, String operation, String businessId, String orderName, String order) {
        return businessDetailsDao.getBusinessDetailsList(businessDetailsId, businessId, userId, deptId, orderName, order);
    }


    public String updateBusinessDetails(String businessDetailsId, String businessId, String userId, String operation) {
        List<Map<String, Object>> businessDetailsList = businessDetailsDao.getBusinessDetailsList(businessDetailsId, businessId, null, null, "cjsj", "desc");
        Map<String, Object> map = commonUtil.getMapForList(businessDetailsList);
        String operationThis = map.get("operation") != null ? map.get("operation").toString() : null;
        if (operationThis == null || operationThis.isEmpty() || "null".equals(operation)) {
//            String businessDetailsId = String.valueOf(map.get("ID"));
            String nodes = String.valueOf(map.get("nodes"));
            Integer steps = Integer.valueOf(String.valueOf(map.get("steps")));
            String[] nodeIds = nodes.split(",");
            String deptId = "";
            if ("1".equals(operation)) {
                steps += 1;
            } else if ("2".equals(operation)) {
                steps -= 1;
            }
            Integer length = nodeIds.length;
            if (steps < length) {
                deptId = nodeIds[steps];
                List<Map<String, Object>> deptList = departmentService.getDepartmentList(deptId, null);
                String deptname = String.valueOf(deptList.get(0).get("deptname"));
                BusinessDetails businessDetails = setBusinessDetails(businessDetailsId, userId, nodes, String.valueOf(steps), deptId, deptname, operation, businessId);
                String id = businessDetailsDao.updateBusinessDetails(businessDetails);
                if ("0".equals(id)) {
                    return id;
                }
                businessDetails.setUserId(null);
                businessDetails.setOperation(null);
                return businessDetailsDao.addBusinessDetails(businessDetails);
            } else {

                BusinessDetails businessDetails = setBusinessDetails(businessDetailsId, userId, nodes, String.valueOf(steps), deptId, null, operation, businessId);
                String id = businessDetailsDao.updateBusinessDetails(businessDetails);
                if ("0".equals(id)) {
                    return id;
                }
                WorkflowBusiness workflowBusiness = new WorkflowBusiness();
                workflowBusiness.setXgsj(aboutTime.getNowTime());
                workflowBusiness.setTaskState("1");
                workflowBusiness.setId(Integer.parseInt(businessId));
                return workflowBusinessDao.updateWorkflowBusiness(workflowBusiness);
            }
        }
        return "0";
    }

    public BusinessDetails setBusinessDetails(String businessDetailsId, String userId, String nodes, String steps, String nodeId, String nodeDetailsId, String operation, String businessId) {
        BusinessDetails businessDetails = new BusinessDetails();
        if (businessDetailsId != null && !businessDetailsId.isEmpty())
            businessDetails.setId(Integer.valueOf(businessDetailsId));
        businessDetails.setUserId(userId);
        businessDetails.setNodes(nodes);
        businessDetails.setSteps(steps);
        businessDetails.setNodeId(nodeId);
        businessDetails.setNodeDetailsId(nodeDetailsId);
        businessDetails.setCjsj(aboutTime.getNowTime());
        businessDetails.setXgsj(aboutTime.getNowTime());
        businessDetails.setOperation(operation);
        businessDetails.setBusinessId(businessId);
        return businessDetails;
    }

}
