package com.controller;

import com.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 用户详情
 */
@Controller
@RequestMapping("userDetails")
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * 用户详情列表
     *
     * @param udId
     * @param userId
     * @param allname
     * @param telephone
     * @return
     */
    @RequestMapping("getUserDetailsList")
    @ResponseBody
    public List<Map<String, Object>> getUserDetailsList(String udId, String userId, String allname, String telephone) {
        return userDetailsService.getUserDetailsList(udId, userId, allname, telephone);
    }

    /**
     * 修改详情信息
     *
     * @param udId
     * @param telephone
     * @param allname
     * @return
     */
    @RequestMapping("updateUserDetailsByUdId")
    @ResponseBody
    public String updateUserDetailsByUdId(String udId, String telephone, String allname) {
        return userDetailsService.updateUserDetailsByUdId(udId, telephone, allname);
    }
}
