package com.dao;

import com.bean.UserProcess;
import com.util.AboutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
public class UserProcessDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AboutTime aboutTime;

    /**
     * 根据用户查询用户流程表
     * @param userId
     * @return
     */
    public List<Map<String,Object>> getUserProcessList(String userId){
        String sql="select to_char(userprocess.writeTime,'yyyy-mm-dd hh24:mi:ss') writeTimes,userprocess.* from file_userprocess userprocess where userprocess.fk_userId='"+userId+"' order by userprocess.writeTime desc";
        List<Map<String,Object>> userProcessList=jdbcTemplate.queryForList(sql);
        return userProcessList;
    }

    /**
     * 新增流程
     *
     * @param userId
     */
    public String addUserProcess(String userId,UserProcess process){
        if (process!=null){
            String sql="INSERT INTO file_userprocess VALUES(SEQ_USERPROCESS_ID.nextval,?, ? ,?, ?, to_date(?,'yyyy-mm-dd hh24:mi:ss'))";
            Integer id=jdbcTemplate.update(sql, new Object[] {
                    process.getStatus(),
                    process.getUserId(),
                    process.getDocumentRecordId(),
                    process.getRejectInformation(),
                    aboutTime.timestampTostring(process.getWriteTime())});

            return id.toString();
        }
        return "0";
    }

    /**
     * 根据流程Id获取流程详细信息
     *
     * @param processId
     * @return
     */
    public Map<String,Object> getUserProcess(String processId){
        String sql="select * from file_userprocess where id='"+processId+"'";
        List<Map<String,Object>> userProcessList=jdbcTemplate.queryForList(sql);
        if (userProcessList!=null&&userProcessList.size()>0){
            Map<String,Object> userProcess=userProcessList.get(0);
            return userProcess;
        }
        return null;
    }
}
