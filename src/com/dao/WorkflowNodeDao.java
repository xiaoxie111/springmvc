package com.dao;

import com.util.AboutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WorkflowNodeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AboutTime aboutTime;

    public int addWorkflowNode(String deptId, String workflowOrder, String workflowId) {
        String sql = "INSERT INTO workflow_node VALUES(seq_workflow_node_id.nextval, ?, ?, ?, to_date(?,'yyyy-mm-dd hh24:mi:ss'))";
        int i=jdbcTemplate.update(sql, new Object[]{
                deptId,
                workflowOrder,
                workflowId,
                aboutTime.timestampTostring(aboutTime.getNowTime())
        });
        return i;
    }


    public List<Map<String, Object>> getWorkflowNodeList(String workflowId) {
        String sql = "select * from workflow_node where workflowid='" + workflowId + "' order by to_number(workflow_order) asc";
        List<Map<String, Object>> workflowNodeList = jdbcTemplate.queryForList(sql);
        return workflowNodeList;
    }
}
