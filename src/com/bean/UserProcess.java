package com.bean;

import java.sql.Timestamp;

public class UserProcess {
    private String status; // 状态
    private String userId; // 用户id
    private String documentRecordId; // 记录表id
    private String rejectInformation; // 驳回信息
    private Timestamp writeTime; // 记录时间

    public UserProcess() {
    }

    public UserProcess(String status, String userId, String documentRecordId, String rejectInformation, Timestamp writeTime) {
        this.status = status;
        this.userId = userId;
        this.documentRecordId = documentRecordId;
        this.rejectInformation = rejectInformation;
        this.writeTime = writeTime;
    }

    public String getDocumentRecordId() {
        return documentRecordId;
    }

    public void setDocumentRecordId(String documentRecordId) {
        this.documentRecordId = documentRecordId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRejectInformation() {
        return rejectInformation;
    }

    public void setRejectInformation(String rejectInformation) {
        this.rejectInformation = rejectInformation;
    }

    public Timestamp getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Timestamp writeTime) {
        this.writeTime = writeTime;
    }
}
