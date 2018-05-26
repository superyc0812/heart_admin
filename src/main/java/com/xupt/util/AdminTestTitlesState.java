package com.xupt.util;

import com.xupt.vo_admin.AdminTestTitle;

import java.util.List;

public class AdminTestTitlesState {

    private Integer state;
    private String msg;
    private List<AdminTestTitle> list;

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

    public List<AdminTestTitle> getList() {
        return list;
    }

    public void setList(List<AdminTestTitle> list) {
        this.list = list;
    }
}
