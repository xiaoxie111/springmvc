package com.bean;


public class User {
    private Integer id;
    private String username;
    private String password;
    private String duty;
    private String deptId;

    public User() {
    }

    public User(Integer id, String username, String password, String duty, String deptId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.duty = duty;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
