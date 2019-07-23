package com.service;

import com.bean.UserProcess;
import com.dao.UserDao;
import com.dao.UserProcessDao;
import com.util.AboutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class UserProcessService {

    @Autowired
    UserProcessDao userProcessDao;

    @Autowired
    AboutTime aboutTime;

    /**
     * 根据用户查询用户流程表
     * @param userId
     * @return
     */
    public List<Map<String,Object>> getUserProcessList(String userId){
        return userProcessDao.getUserProcessList(userId);
    }

    /**
     * 新增流程
     *
     * @param userId
     */
    public String addUserProcess(String status, String userId, String documentRecordId, String rejectInformation){
        UserProcess userProcess=new UserProcess( status,  userId,  documentRecordId,  rejectInformation, aboutTime.getNowTime());
        return userProcessDao.addUserProcess(userId, userProcess);
    }

    /**
     * 根据流程Id获取流程详细信息
     *
     * @param processId
     * @return
     */
    public Map<String,Object> getUserProcess(String processId){
        return userProcessDao.getUserProcess(processId);
    }
}
