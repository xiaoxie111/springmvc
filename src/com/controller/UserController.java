package com.controller;


import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取用户列表
     *
     * @param userId
     * @param username
     * @param duty
     * @param deptId
     * @return
     */
    @RequestMapping("getUserList")
    @ResponseBody
    public List<Map<String, Object>> getUserList(String userId, String username, String duty, String deptId) {
        return userService.getUserList(userId, username, duty, deptId);
    }

    /**
     * 注册
     *
     * @param username
     * @param password
     * @param password2
     * @param duty
     * @param deptId
     */
    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(String username, String password, String password2, String duty, String deptId) {
        if (password != null && !password.isEmpty() && password.equals(password2)) {
            if (username == null || username.isEmpty()) {
                return "用户名不能为空";
            } else if (duty == null || duty.isEmpty()) {
                return "职位不能为空";
            } else if (deptId == null || deptId.isEmpty()) {
                return "必须关联部门";
            } else {
                return userService.addUser(username, password, duty, deptId);
            }
        } else {
            return "两次密码不一致或为空";
        }
    }

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(String username, String password) {
        if (username == null || username.isEmpty()) {
            return "用户名不能为空";
        } else if (password == null || password.isEmpty()) {
            return "密码不能为空";
        } else {
            return userService.login(username, password);
        }
    }
}
