package com.dao;

import com.util.AboutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DepartmentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AboutTime aboutTime;

    public String addDepartmrnt(String deptName) {
        String sql = "INSERT INTO Sys_Department VALUES(seq_sys_department_id.nextval,?, to_date(?,'yyyy-mm-dd hh24:mi:ss'))";
        System.out.println(sql);
        return Integer.toString(jdbcTemplate.update(sql, new Object[]{
                deptName,
                aboutTime.timestampTostring(aboutTime.getNowTime())}));

    }

    public List<Map<String, Object>> getDeptList(String deptId, String deptName) {
        String sql = "select * from Sys_Department where 1=1 ";
        if (deptId != null && !deptId.isEmpty()) {
            sql += " and id = '" + deptId + "' ";
        }
        if (deptName != null && !deptName.isEmpty()) {
            sql += " and deptName like '%" + deptName + "%'";
        }
        List<Map<String, Object>> deptList = jdbcTemplate.queryForList(sql);
        return deptList;
    }


    public String deleteDepartment(String id) {
        String sql = "delete from Sys_Department where id=?";
        int i = jdbcTemplate.update(sql, new Object[]{id});
        return String.valueOf(i);
    }

    public String updateDepartmrnt(String deptName, String id) {
        String sql = "update Sys_Department set deptname=?, cjsj=to_date(?,'yyyy-mm-dd hh24:mi:ss') where id=?";
        int i = jdbcTemplate.update(sql, new Object[]{
                deptName,
                aboutTime.timestampTostring(aboutTime.getNowTime()),
                id});
        return String.valueOf(i);

    }
}
