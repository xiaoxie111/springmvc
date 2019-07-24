package com.dao;

import com.bean.WorkflowBusiness;
import com.util.AboutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WorkflowBusinessDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AboutTime aboutTime;

    public String addWorkflowBusiness(WorkflowBusiness workflowBusiness) {
        String sql = "INSERT INTO workflow_business VALUES" +
                " (seq_workflow_business_id.nextval,?, ?, to_date(?,'yyyy-mm-dd hh24:mi:ss'), to_date(?,'yyyy-mm-dd hh24:mi:ss'), ?, ?)";
        int i = jdbcTemplate.update(sql, new Object[]{
                workflowBusiness.getUserId(),
                workflowBusiness.getNodes(),
                aboutTime.timestampTostring(workflowBusiness.getCjsj()),
                aboutTime.timestampTostring(workflowBusiness.getXgsj()),
                workflowBusiness.getWorkflowId(),
                workflowBusiness.getTaskState()
        });
        return String.valueOf(i);
    }

    public String updateWorkflowBusiness(WorkflowBusiness workflowBusiness) {
        String sql = "update workflow_business set taskState=? , xgsj=to_date(?,'yyyy-mm-dd hh24:mi:ss') where id = ?";
        int i = jdbcTemplate.update(sql, new Object[]{
                workflowBusiness.getTaskState(),
                aboutTime.timestampTostring(workflowBusiness.getXgsj()),
                workflowBusiness.getId()
        });
        return String.valueOf(i);
    }


    public List<Map<String, Object>> getWorkflowBusinessList(String workflowId, String taskState, String userId, String orderName, String order) {
        String sql = "select wb.*, " +
                "       su.username, " +
                "       w.workflow_name, " +
                "       (select sd.deptname from sys_department sd where sd.id = su.deptid) deptname " +
                "  from workflow_business wb, sys_user su, workflow w " +
                " where wb.userid = su.id " +
                "   and wb.workflowid = w.id ";
        if (workflowId != null && !workflowId.isEmpty()) {
            sql += " and wb.workflowId = '" + workflowId + "'";
        }
        if (taskState != null && !taskState.isEmpty()) {
            sql += " and wb.taskState = '" + taskState + "'";
        }
        if (userId != null && !userId.isEmpty()) {
            sql += " and wb.userId = '" + userId + "'";
        }
        if (orderName != null && !orderName.isEmpty()) {
            sql += " order by wb." + orderName + "  " + order;
        }
        System.out.println(sql);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
