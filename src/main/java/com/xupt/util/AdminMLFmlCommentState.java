package com.xupt.util;

import com.xupt.vo_admin.AdminFmlComment;

import java.util.List;

public class AdminMLFmlCommentState {
    private Integer state;
    private String msg;
    private List<AdminFmlComment> list;

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

    public List<AdminFmlComment> getList() {
        return list;
    }

    public void setList(List<AdminFmlComment> list) {
        this.list = list;
    }
}
