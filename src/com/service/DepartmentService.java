package com.service;

import com.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    public List<Map<String, Object>> getDepartmentList(String deptId, String deptname) {
        List<Map<String, Object>> deptList = departmentDao.getDeptList(deptId, deptname);
        return deptList;
    }

    public String addDepartment(String deptname) {
        List<Map<String, Object>> deptList = departmentDao.getDeptList(null, deptname);
        if (deptList == null || deptList.size() == 0) {
            return departmentDao.addDepartmrnt(deptname);
        }
        return "0";
    }

    public String deleteDepartment(String deptId) {
        return departmentDao.deleteDepartment(deptId);
    }

    public String updateDepartment(String deptId, String deptname) {
        return departmentDao.updateDepartmrnt(deptname,deptId);
    }
}
