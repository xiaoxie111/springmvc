package com.service;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<Map<String, Object>> getUserList(String userId, String username, String duty, String deptId) {
        return userDao.getUserList(userId, username, duty, deptId);
    }

    public String addUser(String username, String password, String duty, String deptId) {
        User user = new User();
        user.setDeptId(deptId);
        user.setDuty(duty);
        user.setPassword(password);
        user.setUsername(username);
        return userDao.addUser(user);
    }
}
