package com.bean;

public class UserDetails {
    private Integer id;
    private String userId;
    private String allname;
    private String telephone;

    public UserDetails() {
    }

    public UserDetails(Integer id, String userId, String allname, String telephone) {
        this.id = id;
        this.userId = userId;
        this.allname = allname;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAllname() {
        return allname;
    }

    public void setAllname(String allname) {
        this.allname = allname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
