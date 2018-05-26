package com.xupt.util;

import com.xupt.vo_admin.AdminUserTestRecord;

import java.util.List;

public class AdminTestRecordsState {
    private Integer state;
    private String msg;
    private List<AdminUserTestRecord> list;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<AdminUserTestRecord> getList() {
        return list;
    }

    public void setList(List<AdminUserTestRecord> list) {
        this.list = list;
    }
}
