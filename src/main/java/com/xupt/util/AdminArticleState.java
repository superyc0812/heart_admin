package com.xupt.util;

import com.xupt.vo_admin.AdminArticle;

public class AdminArticleState {
    private Integer state;
    private String msg;
    private AdminArticle list;

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

    public AdminArticle getList() {
        return list;
    }

    public void setList(AdminArticle list) {
        this.list = list;
    }
}
