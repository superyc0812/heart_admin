package com.xupt.util;

import com.xupt.vo_admin.AdminTestPaper2;

public class AdminTestPaperState {
    private Integer state;
    private String msg;
    private AdminTestPaper2 list;

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

    public AdminTestPaper2 getList() {
        return list;
    }

    public void setList(AdminTestPaper2 list) {
        this.list = list;
    }
}
