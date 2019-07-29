package com.dao;

import com.bean.BusinessDetails;
import com.util.AboutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BusinessDetailsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AboutTime aboutTime;

    public String addBusinessDetails(BusinessDetails businessDetails) {
        String sql = "INSERT INTO business_details VALUES" +
                " (seq_business_details_id.nextval,?, ?, ?, ?, ?, to_date(?,'yyyy-mm-dd hh24:mi:ss'), to_date(?,'yyyy-mm-dd hh24:mi:ss'), ?, ?)";
        int i = jdbcTemplate.update(sql, new Object[]{
                businessDetails.getUserId(),
                businessDetails.getNodes(),
                businessDetails.getSteps(),
                businessDetails.getNodeId(),
                businessDetails.getNodeDetailsId(),
                aboutTime.timestampTostring(businessDetails.getCjsj()),
                aboutTime.timestampTostring(businessDetails.getXgsj()),
                businessDetails.getOperation(),
                businessDetails.getBusinessId()
        });
        return String.valueOf(i);
    }

    public String updateBusinessDetails(BusinessDetails businessDetails) {
        String sql = "update business_details set userId = ? ,operation = ? , xgsj=to_date(?,'yyyy-mm-dd hh24:mi:ss') where id = ?";
        int i = jdbcTemplate.update(sql, new Object[]{
                businessDetails.getUserId(),
                businessDetails.getOperation(),
                aboutTime.timestampTostring(businessDetails.getXgsj()),
                businessDetails.getId()
        });
        return String.valueOf(i);
    }

    public List<Map<String, Object>> getBusinessDetailsList(String businessDetailsId, String businessId, String userId, String nodeId, String orderName, String order) {
        String sql = "select * from business_details where 1=1 ";
        if (businessDetailsId != null && !businessDetailsId.isEmpty()) {
            sql += " and id = '" + businessDetailsId + "'";
        }
        if (businessId != null && !businessId.isEmpty()) {
            sql += " and businessId = '" + businessId + "'";
        }
        if (userId != null && !userId.isEmpty()) {
            sql += " and userId = '" + userId + "'";
        }
        if (nodeId != null && !nodeId.isEmpty()) {
            sql += " and nodeId = '" + nodeId + "'";
        }
        if (orderName != null && !orderName.isEmpty()) {
            sql += " order by " + orderName + "  " + order;
        }
        System.out.println("BusinessDetailsList" + sql);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
