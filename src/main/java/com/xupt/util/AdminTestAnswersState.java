package com.xupt.util;

import com.xupt.vo_admin.AdminTestAnswer;


public class AdminTestAnswersState {
    private Integer state;
    private String msg;
    private AdminTestAnswer list;

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

    public AdminTestAnswer getList() {
        return list;
    }

    public void setList(AdminTestAnswer list) {
        this.list = list;
    }
}
