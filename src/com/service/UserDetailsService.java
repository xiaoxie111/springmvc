package com.service;

import com.dao.UserDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsDao userDetailsDao;

    public List<Map<String, Object>> getUserDetailsList(String udId, String userId, String allname, String telephone) {
        return userDetailsDao.getUserDetailsList(udId, userId, allname, telephone);
    }

    public String updateUserDetailsByUdId(String udId, String telephone, String allname) {
        return userDetailsDao.updateUserDetailsByUdId(udId, telephone, allname);
    }
}
