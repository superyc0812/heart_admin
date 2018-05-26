package com.xupt.util;

import com.xupt.vo_admin.AdminForumType;

import java.util.List;

public class AdminForumTypesState {
    private Integer state;
    private String msg;
    private List<AdminForumType> list;

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

    public List<AdminForumType> getList() {
        return list;
    }

    public void setList(List<AdminForumType> list) {
        this.list = list;
    }
}
