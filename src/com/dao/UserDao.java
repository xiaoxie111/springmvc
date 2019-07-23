package com.dao;

import com.bean.User;
import com.util.AboutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AboutTime aboutTime;

    public List<Map<String, Object>> getUserList(String userId, String username, String duty, String deptId) {
        String sql = "select * from sys_user where 1=1 ";
        if (userId != null && !userId.isEmpty()) {
            sql += " and id = '" + userId + "' ";
        }
        if (username != null && !username.isEmpty()) {
            sql += " and username like '%" + username + "%' ";
        }
        if (duty != null && !duty.isEmpty()) {
            sql += " and duty = '" + duty + "' ";
        }
        if (deptId != null && !deptId.isEmpty()) {
            sql += " and deptId = '" + deptId + "'";
        }
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);
        return userList;
    }

    public String addUser(User user) {
        String sql = "INSERT INTO sys_user VALUES(seq_sys_user_id.nextval,?, ? ,?, ?, to_date(?,'yyyy-mm-dd hh24:mi:ss'))";
        int i = jdbcTemplate.update(sql, new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getDuty(),
                user.getDeptId(),
                aboutTime.timestampTostring(aboutTime.getNowTime())});
        return String.valueOf(i);
    }

    public void updateUserofPassword(String userId, String password) {
        String sql = "update sys_user set password=? where id = ?";
        jdbcTemplate.update(sql, new Object[]{password, userId});
    }

    public void deleteUser(String userId) {
        String sql = " delete from sys_user where id = ? ";
        jdbcTemplate.update(sql, userId);

    }
}
