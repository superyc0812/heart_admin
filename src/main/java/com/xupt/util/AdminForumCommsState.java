package com.xupt.util;

import com.xupt.vo_admin.AdminForumComment;

import java.util.List;

public class AdminForumCommsState {

    private Integer state;
    private String msg;
    private List<AdminForumComment> list;

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

    public List<AdminForumComment> getList() {
        return list;
    }

    public void setList(List<AdminForumComment> list) {
        this.list = list;
    }
}
