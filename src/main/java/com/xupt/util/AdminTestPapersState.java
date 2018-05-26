package com.xupt.util;

import com.xupt.vo_admin.AdminTestPaper;

import java.util.List;

public class AdminTestPapersState {
    private Integer state;
    private String msg;
    private Integer total;
    private List<AdminTestPaper> list;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<AdminTestPaper> getList() {
        return list;
    }

    public void setList(List<AdminTestPaper> list) {
        this.list = list;
    }
}
