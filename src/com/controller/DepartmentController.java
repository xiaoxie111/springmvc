package com.controller;

import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("getDepartmentList")
    @ResponseBody
    public List<Map<String, Object>> getDepartmentList(String deptId, String deptname) {
        List<Map<String, Object>> deptList = departmentService.getDepartmentList(deptId, deptname);
        return deptList;
    }

    @RequestMapping("addDepartment")
    @ResponseBody
    public String addDepartment(String deptname) {
       return departmentService.addDepartment(deptname);
    }

    @RequestMapping("deleteDepartment")
    @ResponseBody
    public String deleteDepartment(String deptId) {
        return departmentService.deleteDepartment(deptId);
    }

    @RequestMapping("updateDepartment")
    @ResponseBody
    public String updateDepartment(String deptId,String deptname) {
        return departmentService.updateDepartment(deptId,deptname);
    }
}
