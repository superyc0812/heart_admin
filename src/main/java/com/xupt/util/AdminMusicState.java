package com.xupt.util;

import com.xupt.vo_admin.AdminMusic2;

public class AdminMusicState {
    private Integer state;
    private String msg;
    private AdminMusic2 list;

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

    public AdminMusic2 getList() {
        return list;
    }

    public void setList(AdminMusic2 list) {
        this.list = list;
    }
}
