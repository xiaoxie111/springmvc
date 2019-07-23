package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkflowBusinessDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addWorkflowBusiness(String nodes, String userId) {

    }
}
