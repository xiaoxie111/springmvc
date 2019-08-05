package com.dao;

import com.bean.User;
import com.bean.UserDetails;
import com.util.AboutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDetailsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AboutTime aboutTime;

    public List<Map<String, Object>> getUserDetailsList(String udId, String userId, String allname, String telephone) {
        String sql = "select sud.*, " +
                "       su.username, " +
                "       su.duty, " +
                "       su.deptid, " +
                "       (select sd.deptname from sys_department sd where sd.id = su.deptid) deptname " +
                "  from sys_userdetails sud, sys_user su " +
                " where sud.userid=su.id";
        if (udId != null && !udId.isEmpty()) {
            sql += " and sud.id = '" + udId + "' ";
        }
        if (userId != null && !userId.isEmpty()) {
            sql += " and sud.userId = '" + userId + "' ";
        }
        if (allname != null && !allname.isEmpty()) {
            sql += " and sud.allname like '%" + allname + "%' ";
        }
        if (telephone != null && !telephone.isEmpty()) {
            sql += " and sud.telephone = '" + telephone + "'";
        }
        List<Map<String, Object>> udList = jdbcTemplate.queryForList(sql);
        return udList;
    }

    public String addUserDetails(UserDetails userDetails) {
        String sql = "INSERT INTO sys_userdetails VALUES(seq_sys_userdetails_id.nextval, ?, ?, ?, to_date(?,'yyyy-mm-dd hh24:mi:ss'))";
        int i = jdbcTemplate.update(sql, new Object[]{
                userDetails.getUserId(),
                userDetails.getAllname(),
                userDetails.getTelephone()});
        return String.valueOf(i);
    }

    public String updateUserDetailsByUdId(String udId, String telephone, String allname) {
        String sql = "update sys_userdetails set telephone = ? , allname = ? , cjsj=to_date(?,'yyyy-mm-dd hh24:mi:ss') where id = ?";
        int i = jdbcTemplate.update(sql, new Object[]{telephone, allname, aboutTime.timestampTostring(aboutTime.getNowTime()), udId});
        return String.valueOf(i);
    }

    public void updateUserDetailsByUserId(String userId, String telephone, String allname) {
        String sql = "update sys_userdetails set telephone = ? , allname = ? where userId = ?";
        jdbcTemplate.update(sql, new Object[]{telephone, allname, userId});
    }

    public void deleteUserDetails(String udId) {
        String sql = " delete from sys_userdetails where id = ? ";
        jdbcTemplate.update(sql, udId);

    }
}
