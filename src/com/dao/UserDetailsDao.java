package com.dao;

import com.bean.User;
import com.bean.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDetailsDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getUserDetailsList(String udId, String userId, String allname, String telephone) {
        String sql = "select * from sys_userdetails where 1=1 ";
        if (udId != null && !udId.isEmpty()) {
            sql += " and id = '" + udId + "' ";
        }
        if (userId != null && !userId.isEmpty()) {
            sql += " and userId = '" + userId + "' ";
        }
        if (allname != null && !allname.isEmpty()) {
            sql += " and allname like '%" + allname + "%' ";
        }
        if (telephone != null && !telephone.isEmpty()) {
            sql += " and telephone = '" + telephone + "'";
        }
        List<Map<String, Object>> udList = jdbcTemplate.queryForList(sql);
        return udList;
    }

    public void addUserDetails(UserDetails userDetails) {
        String sql = "INSERT INTO sys_userdetails VALUES(seq_sys_userdetails_id.nextval,?, ? ,?)";
        jdbcTemplate.update(sql, new Object[]{
                userDetails.getUserId(),
                userDetails.getAllname(),
                userDetails.getTelephone()});
    }

    public void updateUserDetailsByUdId(String udId, String telephone,String allname) {
        String sql = "update sys_userdetails set telephone = ? , allname = ? where id = ?";
        jdbcTemplate.update(sql, new Object[]{telephone , allname , udId});
    }

    public void updateUserDetailsByUserId(String userId, String telephone,String allname) {
        String sql = "update sys_userdetails set telephone = ? , allname = ? where userId = ?";
        jdbcTemplate.update(sql, new Object[]{telephone , allname , userId});
    }

    public void deleteUserDetails(String udId) {
        String sql = " delete from sys_userdetails where id = ? ";
        jdbcTemplate.update(sql, udId);

    }
}
