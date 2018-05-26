package com.xupt.util;

import com.xupt.vo_admin.AdminArticleComment;

import java.util.List;

public class AdminArticleCommentState {
    private Integer state;
    private String msg;
    private List<AdminArticleComment> list;

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

    public List<AdminArticleComment> getList() {
        return list;
    }

    public void setList(List<AdminArticleComment> list) {
        this.list = list;
    }
}
