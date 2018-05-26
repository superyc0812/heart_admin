package com.xupt.util;

import com.xupt.vo_admin.AdminTestPaperType;

import java.util.List;

public class AdminTestPaperTypesState {
    private Integer state;
    private String msg;
    private List<AdminTestPaperType> list;

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

    public List<AdminTestPaperType> getList() {
        return list;
    }

    public void setList(List<AdminTestPaperType> list) {
        this.list = list;
    }
}
