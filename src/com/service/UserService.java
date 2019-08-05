package com.service;

import com.bean.User;
import com.bean.UserDetails;
import com.dao.UserDao;
import com.dao.UserDetailsDao;
import com.util.AboutTime;
import com.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    CommonUtil commonUtil;

    @Autowired
    UserDetailsDao userDetailsDao;

    @Autowired
    AboutTime aboutTime;

    public List<Map<String, Object>> getUserList(String userId, String username, String duty, String deptId) {
        return userDao.getUserList(userId, username, duty, deptId);
    }

    public String addUser(String username, String password, String duty, String deptId) {
        User user = new User();
        user.setDeptId(deptId);
        user.setDuty(duty);
        user.setPassword(password);
        user.setUsername(username);
        String id = userDao.addUser(user);
        if (id.equals("0")) {
            return id;
        }
        List<Map<String, Object>> userList = userDao.getUserList(null, username, duty, deptId);
        Map<String, Object> userMap = commonUtil.getMapForList(userList);
        String userId = String.valueOf(userMap.get("Id"));
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(userId);
        userDetails.setCjsj(aboutTime.getNowTime());
        return userDetailsDao.addUserDetails(userDetails);
    }

    public String login(String username, String password) {
        List<Map<String, Object>> list = userDao.login(username, password);
        return (list != null && list.size() > 0) ? "1" : "0";
    }
}
