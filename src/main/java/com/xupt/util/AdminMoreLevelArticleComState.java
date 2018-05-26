package com.xupt.util;

import com.xupt.vo_admin.AdminAmlComment;

import java.util.List;

public class AdminMoreLevelArticleComState {
    private Integer state;
    private String msg;
    private List<AdminAmlComment> list;

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

    public List<AdminAmlComment> getList() {
        return list;
    }

    public void setList(List<AdminAmlComment> list) {
        this.list = list;
    }
}
