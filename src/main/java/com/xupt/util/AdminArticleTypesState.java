package com.xupt.util;

import com.xupt.vo_admin.AdminArticleType;

import java.util.List;

public class AdminArticleTypesState {
    private Integer state;
    private String msg;
    private List<AdminArticleType> list;

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

    public List<AdminArticleType> getList() {
        return list;
    }

    public void setList(List<AdminArticleType> list) {
        this.list = list;
    }
}
