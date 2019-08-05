package com.dao;

import com.util.AboutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Repository
public class WorkflowDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AboutTime aboutTime;

    public String addWorkflow(String workflow_name, String workflow_desc) {
        String sql = "INSERT INTO workflow VALUES(seq_workflow_id.nextval,?, ?, to_date(?,'yyyy-mm-dd hh24:mi:ss'))";
        int i = jdbcTemplate.update(sql, new Object[]{
                workflow_name,
                workflow_desc,
                aboutTime.timestampTostring(aboutTime.getNowTime())});
        return String.valueOf(i);
    }


    public List<Map<String, Object>> getWorkflowList(String workfId, String workflow_name, String workflow_desc, String orderName, String order, String effect) {
        String sql = "select w.* ,to_char(w.cjsj,'yyyy-mm-dd hh24:mi:ss') cjsj from workflow w where 1=1 ";

        if (effect != null && !effect.isEmpty()) {
            sql += " and w.id in (select workflowId from workflow_node) ";
        }
        if (workfId != null && !workfId.isEmpty()) {
            sql += " and w.id = '" + workfId + "'";
        }
        if (workflow_name != null && !workflow_name.isEmpty()) {
            sql += " and w.workflow_name like '%" + workflow_name + "%'";
        }
        if (workflow_desc != null && !workflow_desc.isEmpty()) {
            sql += " and w.workflow_desc like '%" + workflow_desc + "%'";
        }
        if (orderName != null && !orderName.isEmpty()) {
            sql += " order by w." + orderName + " " + order;
        }
        System.out.println(sql);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }


}
